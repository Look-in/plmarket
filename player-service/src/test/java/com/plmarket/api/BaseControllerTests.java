package com.plmarket.api;

import com.plmarket.PlayerServiceBootApplicationTests;
import com.plmarket.domain.BaseEntity;
import com.plmarket.model.BaseModel;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseControllerTests<T extends BaseEntity, S extends BaseModel>
        extends PlayerServiceBootApplicationTests {

    protected S createdModel;

    protected S newModel;

    protected abstract BaseController<T, S> controller();

    @Test
    public void createTest() {
        S created = controller().create(newModel);
        Assertions.assertNotNull(created.id());
    }

    @Test
    public void updateTest() {
        createdModel.name("updated name");
        controller().update(createdModel);
        S updated = controller().read(createdModel.id());
        Assertions.assertEquals(createdModel.name(), updated.name());
    }

    @Test
    public void deleteTest() {
        BaseController<T, S> controller = controller();
        controller.delete(createdModel.id());
        UUID id = createdModel.id();
        Assertions.assertThrows(IllegalArgumentException.class, () -> controller.read(id));
    }

    @Test
    public void findAllTest() {
        List<S> all = controller().findAll();
        Assertions.assertTrue(all.stream().anyMatch(e -> createdModel.id().equals(e.id())));
    }

    @Test
    public void findAllByPageTest() {
        Page<S> allPage = controller().findAllByPage(PageRequest.of(0, 1000, Sort.by("id")));
        Assertions.assertTrue(allPage.getContent().stream().anyMatch(e -> createdModel.id().equals(e.id())));
    }

}
