package com.plmarket.service;

import com.plmarket.domain.Player;
import com.plmarket.domain.Team;
import com.plmarket.repository.PlayerRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player Service implementation.
 *
 * @author SShankunas
 */
@Service
@Transactional
public class PlayerServiceImpl extends BaseCrudService<Player, PlayerRepository> implements PlayerService {

    @Override
    public void transfer(UUID id, UUID teamId) {
        Team team = new Team();
        team.id(teamId);
        repository.transfer(id, team);
    }

    @Override
    public void remove(UUID id) {
        repository.remove(id);
    }

}
