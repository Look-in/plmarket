package com.plmarket.api.player;

import com.plmarket.api.BaseController;
import com.plmarket.domain.Player;
import com.plmarket.service.PlayerService;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Player controller.
 *
 * @author SShankunas
 */
@RestController
@RequestMapping("/player")
public class PlayerController extends BaseController<Player, PlayerModel, PlayerService> {

    @PostMapping("/{id}/transfer/{teamId}")
    public void transfer(@PathVariable UUID id, @PathVariable UUID teamId) {
        service.transfer(id, teamId);
    }

    @PostMapping("/{id}")
    public void remove(@PathVariable UUID id) {
        service.remove(id);
    }

}
