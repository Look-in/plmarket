package com.plmarket.api;

import com.plmarket.api.player.PlayerModel;
import com.plmarket.api.team.TeamModel;
import com.plmarket.domain.Player;
import com.plmarket.factory.PlayerFactory;
import com.plmarket.factory.TeamFactory;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player api tests.
 *
 * @author SShankunas
 */
@Transactional
public class PlayerControllerTests extends BaseControllerTests<Player, PlayerModel> {

    @Override
    protected BaseController<Player, PlayerModel> controller() {
        return playerController;
    }

    @BeforeEach
    public void init() {
        TeamModel team = teamController.create(TeamFactory.createModel("Test team", BigDecimal.valueOf(8)));
        newModel = PlayerFactory.createModel("New test model", 20, team);
        createdModel = playerController.create(PlayerFactory.createModel("Created test model", 25, team));
    }

}
