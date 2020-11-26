package com.plmarket.domain;

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

    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
