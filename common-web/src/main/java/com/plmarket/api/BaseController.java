package com.plmarket.api;

import com.plmarket.domain.BaseEntity;
import com.plmarket.model.BaseModel;
import com.plmarket.repository.BaseRepository;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A controller with the basic behavior of inherited BaseEntity objects.
 * To use this class have to implement repository and override abstract method
 * getRepository() returning this rep. Also have to parameterize extended
 * class by {@link BaseEntity} and {@link BaseModel} inherited classes.
 *
 * @author SShankunas
 */
@Slf4j
@Transactional(readOnly = true)
public abstract class BaseController<T extends BaseEntity, S extends BaseModel> {

    @Setter(onMethod_ = {@Autowired})
    protected ModelMapper modelMapper;

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    @SuppressWarnings("unchecked")
    private final Class<S> modelClass = (Class<S>) ((ParameterizedType) this.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[1];

    protected abstract BaseRepository<T> getRepository();

    /**
     * Gets all parameterized objects.
     *
     * @return a list of parameterized objects.
     */
    @GetMapping
    public List<S> findAll() {
        return toModels(this.getRepository().findAll());
    }

    /**
     * Gets page of parameterized objects.
     *
     * @param pageable Pageable params.
     * @return a page of parameterized objects.
     */
    @GetMapping("/page")
    public Page<S> findAllByPage(Pageable pageable) {
        return toModelPage(getRepository().findAll(pageable));
    }

    /**
     * Gets one parameterized object by id.
     *
     * @param id identity.
     * @return parameterized object.
     */
    @GetMapping("/{id}")
    public S read(@PathVariable UUID id) {
        return toModel(this.getRepository().findById(id).orElseThrow(IllegalArgumentException::new));
    }

    /**
     * Creates new parameterized object.
     *
     * @param model parameterized object.
     * @return created object.
     */
    @PostMapping
    @Transactional
    public S create(@Valid @RequestBody S model) {
        return toModel(this.getRepository().save(toDomain(model)));
    }

    /**
     * Updates parameterized object.
     *
     * @param model parameterized object.
     * @return updated object.
     */
    @PutMapping("/{id}")
    @Transactional
    public S update(@Valid @RequestBody S model) {
        return toModel(this.getRepository().save(toDomain(model)));
    }

    /**
     * Deletes parameterized object by id.
     *
     * @param id identity
     */
    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        getRepository().deleteById(id);
    }

    /**
     * Clones object of the model class to the object of the domain class.
     *
     * @param model model object.
     * @return domain object.
     */
    protected T toDomain(@NonNull S model) {
        return modelMapper.map(model, entityClass);
    }

    /**
     * Clones object of the domain class to the object of the model class.
     *
     * @param domain domain object.
     * @return model object.
     */
    protected S toModel(@NonNull T domain) {
        return modelMapper.map(domain, modelClass);
    }

    /**
     * Clones list of the domain object to the list of model objects.
     *
     * @param domains List of domain object.
     * @return List of model objects.
     */
    protected List<S> toModels(@NonNull Iterable<T> domains) {
        return StreamSupport.stream(domains.spliterator(), false)
                .map(this::toModel).collect(Collectors.toList());
    }

    /**
     * Clones page of the domain object to the page of model objects.
     *
     * @param domainPage Page of domain object.
     * @return Page of model objects.
     */
    protected Page<S> toModelPage(@NonNull Page<T> domainPage) {
        return domainPage.map(this::toModel);
    }

}
