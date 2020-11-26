package com.plmarket.api.team;

import com.plmarket.api.BaseController;
import com.plmarket.domain.Team;
import com.plmarket.service.TeamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Team controller.
 *
 * @author SShankunas
 */
@RestController
@RequestMapping("/team")
public class TeamController extends BaseController<Team, TeamModel, TeamService> {
}
