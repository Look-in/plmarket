package com.plmarket.api;

import com.plmarket.api.team.TeamModel;
import com.plmarket.domain.Team;
import com.plmarket.factory.TeamFactory;
import com.plmarket.service.TeamService;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.transaction.annotation.Transactional;

/**
 * Team api tests.
 *
 * @author SShankunas
 */
@Transactional
public class TeamControllerTests extends BaseControllerTests<Team, TeamModel, TeamService> {

    @Override
    protected BaseController<Team, TeamModel, TeamService> controller() {
        return teamController;
    }

    @BeforeEach
    public void init() {
        newModel = TeamFactory.createModel("New test model", BigDecimal.valueOf(8));
        createdModel = teamController.create(TeamFactory.createModel("New test model", BigDecimal.valueOf(3)));
    }

}
