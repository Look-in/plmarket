package com.plmarket.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Player entity.
 *
 * @author SShankunas
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Player extends BaseEntity {

    private LocalDate birthday;

    @Column(updatable = false)
    private LocalDate contractDate;

    @ManyToOne
    @JoinColumn(name = "team_id", updatable = false)
    private Team team;

}
