package com.plmarket.api;

import com.plmarket.api.team.TeamModel;
import com.plmarket.domain.Team;
import com.plmarket.factory.TeamFactory;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.transaction.annotation.Transactional;

/**
 * Team api tests.
 *
 * @author SShankunas
 */
@Transactional
public class TeamControllerTests extends BaseControllerTests<Team, TeamModel> {

    @Override
    protected BaseController<Team, TeamModel> controller() {
        return teamController;
    }

    @BeforeEach
    public void init() {
        TeamModel team = teamController.create(TeamFactory.createModel("Test team", BigDecimal.valueOf(8)));
        newModel = TeamFactory.createModel("New test model", BigDecimal.valueOf(8));
        createdModel = teamController.create(TeamFactory.createModel("New test model", BigDecimal.valueOf(3)));
    }

}
