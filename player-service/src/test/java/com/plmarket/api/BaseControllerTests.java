package com.plmarket.api;

import com.plmarket.PlayerServiceBootApplicationTests;
import com.plmarket.domain.BaseEntity;
import com.plmarket.model.BaseModel;
import com.plmarket.service.CrudService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseControllerTests<T extends BaseEntity, M extends BaseModel, S extends CrudService<T>>
        extends PlayerServiceBootApplicationTests {

    protected M createdModel;

    protected M newModel;

    protected abstract BaseController<T, M, S> controller();

    @Test
    public void createTest() {
        M created = controller().create(newModel);
        Assertions.assertNotNull(created.id());
    }

    @Test
    public void updateTest() {
        createdModel.name("updated name");
        controller().update(createdModel);
        M updated = controller().read(createdModel.id());
        Assertions.assertEquals(createdModel.name(), updated.name());
    }

    @Test
    public void deleteTest() {
        BaseController<T, M, S> controller = controller();
        controller.delete(createdModel.id());
        UUID id = createdModel.id();
        Assertions.assertThrows(IllegalArgumentException.class, () -> controller.read(id));
    }

    @Test
    public void findAllTest() {
        List<M> all = controller().findAll();
        Assertions.assertTrue(all.stream().anyMatch(e -> createdModel.id().equals(e.id())));
    }

}
