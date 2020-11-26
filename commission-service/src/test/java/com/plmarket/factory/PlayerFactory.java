package com.plmarket.factory;

import com.plmarket.domain.Player;
import com.plmarket.domain.Team;
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

    public Player create(@NonNull String name, LocalDate contractDate, LocalDate birthday, Team team) {
        Player player = new Player().team(team).contractDate(contractDate).birthday(birthday);
        player.name(name);
        return player;
    }

}
