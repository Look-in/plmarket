package com.plmarket.factory;

import com.plmarket.api.player.PlayerModel;
import com.plmarket.api.team.TeamModel;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Player factory.
 *
 * @author SShankunas
 */
@UtilityClass
public class PlayerFactory {

    public PlayerModel createModel(@NonNull String name, int age, TeamModel team) {
        PlayerModel player = new PlayerModel().team(team).age(age);
        player.name(name);
        return player;
    }

}
