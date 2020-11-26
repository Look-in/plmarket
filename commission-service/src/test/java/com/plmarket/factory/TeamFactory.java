package com.plmarket.factory;

import com.plmarket.domain.Team;
import java.math.BigDecimal;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

/**
 * Team factory.
 *
 * @author SShankunas
 */
@UtilityClass
public class TeamFactory {

    public Team create(@NonNull String name, @NonNull BigDecimal commission) {
        Team team = new Team().commission(commission);
        team.name(name);
        return team;
    }

}
