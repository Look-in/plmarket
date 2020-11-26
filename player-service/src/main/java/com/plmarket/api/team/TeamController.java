package com.plmarket.api.team;

import com.plmarket.api.BaseController;
import com.plmarket.domain.Team;
import com.plmarket.repository.BaseRepository;
import com.plmarket.repository.TeamRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Team controller.
 *
 * @author SShankunas
 */
@RestController
@RequestMapping("/team")
public class TeamController extends BaseController<Team, TeamModel> {

    @Setter(onMethod_ = {@Autowired})
    private TeamRepository teamRepository;

    @Override
    protected BaseRepository<Team> getRepository() {
        return teamRepository;
    }

}
