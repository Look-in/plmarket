package com.plmarket.api.player;

import com.plmarket.api.BaseController;
import com.plmarket.domain.Player;
import com.plmarket.repository.BaseRepository;
import com.plmarket.repository.PlayerRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Player controller.
 *
 * @author SShankunas
 */
@RestController
@RequestMapping("/player")
public class PlayerController extends BaseController<Player, PlayerModel> {

    @Setter(onMethod_ = {@Autowired})
    private PlayerRepository playerRepository;

    @Override
    protected BaseRepository<Player> getRepository() {
        return playerRepository;
    }

}
