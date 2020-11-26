package com.plmarket.service;

import com.plmarket.domain.Team;
import com.plmarket.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Team Service implementation.
 *
 * @author SShankunas
 */
@Service
@Transactional
public class TeamServiceImpl extends BaseCrudService<Team, TeamRepository> implements TeamService {
}
