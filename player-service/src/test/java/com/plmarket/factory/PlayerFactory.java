package com.plmarket.factory;

import com.plmarket.api.player.PlayerModel;
import com.plmarket.api.team.TeamModel;
import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Player factory.
 *
 * @author SShankunas
 */
@UtilityClass
public class PlayerFactory {

    public PlayerModel createModel(@NonNull String name, LocalDate contractDate, LocalDate birthday, TeamModel team) {
        PlayerModel player = new PlayerModel().team(team).contractDate(contractDate).birthday(birthday);
        player.name(name);
        return player;
    }

}
