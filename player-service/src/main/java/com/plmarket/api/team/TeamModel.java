package com.plmarket.api.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.plmarket.model.BaseModel;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Team model.
 *
 * @author SShankunas
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TeamModel extends BaseModel {

    @Min(0)
    @Max(10)
    @NotNull
    private BigDecimal commission;

}
