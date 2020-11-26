package com.plmarket.api.player;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.plmarket.api.team.TeamModel;
import com.plmarket.model.BaseModel;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Player model.
 *
 * @author SShankunas
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"team"})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayerModel extends BaseModel {

    @Min(18)
    @Max(60)
    @NotNull
    private int age;

    private TeamModel team;

}
