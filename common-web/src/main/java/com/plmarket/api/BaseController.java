package com.plmarket.api;

import com.plmarket.domain.BaseEntity;
import com.plmarket.model.BaseModel;
import com.plmarket.service.CrudService;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.validation.Valid;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * repository returning this rep. Also have to parameterize extended
 * class by {@link BaseEntity} and {@link BaseModel} inherited classes.
 *
 * @author SShankunas
 */
public abstract class BaseController<T extends BaseEntity, M extends BaseModel, S extends CrudService<T>> {

    @Autowired
    protected ModelMapper modelMapper;

    @Autowired
    protected S service;

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) this.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    @SuppressWarnings("unchecked")
    private final Class<M> modelClass = (Class<M>) ((ParameterizedType) this.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[1];

    /**
     * Gets all parameterized objects.
     *
     * @return a list of parameterized objects.
     */
    @GetMapping
    public List<M> findAll() {
        return toModels(this.service.findAll());
    }

    /**
     * Gets one parameterized object by id.
     *
     * @param id identity.
     * @return parameterized object.
     */
    @GetMapping("/{id}")
    public M read(@PathVariable UUID id) {
        return toModel(this.service.read(id));
    }

    /**
     * Creates new parameterized object.
     *
     * @param model parameterized object.
     * @return created object.
     */
    @PostMapping
    public M create(@Valid @RequestBody M model) {
        return toModel(this.service.create(toDomain(model)));
    }

    /**
     * Updates parameterized object.
     *
     * @param model parameterized object.
     * @return updated object.
     */
    @PutMapping("/{id}")
    public M update(@Valid @RequestBody M model) {
        return toModel(this.service.update(toDomain(model)));
    }

    /**
     * Deletes parameterized object by id.
     *
     * @param id identity
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    /**
     * Clones object of the model class to the object of the domain class.
     *
     * @param model model object.
     * @return domain object.
     */
    protected T toDomain(@NonNull M model) {
        return modelMapper.map(model, entityClass);
    }

    /**
     * Clones object of the domain class to the object of the model class.
     *
     * @param domain domain object.
     * @return model object.
     */
    protected M toModel(@NonNull T domain) {
        return modelMapper.map(domain, modelClass);
    }

    /**
     * Clones list of the domain object to the list of model objects.
     *
     * @param domains List of domain object.
     * @return List of model objects.
     */
    protected List<M> toModels(@NonNull Iterable<T> domains) {
        return StreamSupport.stream(domains.spliterator(), false)
                .map(this::toModel).collect(Collectors.toList());
    }

}
