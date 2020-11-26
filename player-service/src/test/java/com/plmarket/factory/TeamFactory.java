package com.plmarket.factory;

import com.plmarket.api.team.TeamModel;
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

    public TeamModel createModel(@NonNull String name, @NonNull BigDecimal commission) {
        TeamModel team = new TeamModel().commission(commission);
        team.name(name);
        return team;
    }

}
