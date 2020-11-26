package com.plmarket.api.player;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plmarket.api.team.TeamModel;
import com.plmarket.model.BaseModel;
import java.time.LocalDate;
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
@JsonIgnoreProperties(value = "contractDate", allowGetters = true)
public class PlayerModel extends BaseModel {

    @NotNull
    private LocalDate birthday;

    private LocalDate contractDate;

    private TeamModel team;

}
