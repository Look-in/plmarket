package com.plmarket.api;

import com.plmarket.api.player.PlayerModel;
import com.plmarket.api.team.TeamModel;
import com.plmarket.domain.Player;
import com.plmarket.factory.PlayerFactory;
import com.plmarket.factory.TeamFactory;
import com.plmarket.service.PlayerService;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player api tests.
 *
 * @author SShankunas
 */
@Transactional
public class PlayerControllerTests extends BaseControllerTests<Player, PlayerModel, PlayerService> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected BaseController<Player, PlayerModel, PlayerService> controller() {
        return playerController;
    }

    @BeforeEach
    public void init() {
        TeamModel team = teamController.create(TeamFactory.createModel("Test team", BigDecimal.valueOf(8)));
        newModel = PlayerFactory.createModel("New test model", LocalDate.parse("1990-01-01"),
                LocalDate.parse("2020-01-01"), team);
        createdModel = playerController.create(PlayerFactory.createModel("Created test model",
                LocalDate.parse("1990-01-01"), LocalDate.parse("2020-01-01"), team));
    }

    @Test
    public void transferPlayerTest() {
        TeamModel team = teamController.create(TeamFactory.createModel("Test team1", BigDecimal.valueOf(8)));
        playerController.transfer(createdModel.id(), team.id());
        entityManager.flush();
        entityManager.clear();
        PlayerModel updated = playerController.read(createdModel.id());
        Assertions.assertEquals(team.id(), updated.team().id());
        Assertions.assertEquals(LocalDate.now(), updated.contractDate());
    }

    @Test
    public void removePlayerTest() {
        playerController.remove(createdModel.id());
        entityManager.flush();
        entityManager.clear();
        PlayerModel updated = playerController.read(createdModel.id());
        Assertions.assertNull(updated.team());
        Assertions.assertNull(updated.contractDate());
    }

}
