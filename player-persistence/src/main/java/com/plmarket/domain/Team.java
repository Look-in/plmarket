package com.plmarket.domain;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Team entity.
 *
 * @author SShankunas
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Team extends BaseEntity {

    private BigDecimal commission;

    @ToString.Exclude
    @OneToMany(mappedBy = "team")
    private List<Player> players;

}
