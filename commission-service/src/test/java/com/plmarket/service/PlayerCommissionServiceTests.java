package com.plmarket.service;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import com.plmarket.CommissionServiceBootApplicationTests;
import com.plmarket.domain.Player;
import com.plmarket.domain.Team;
import com.plmarket.factory.PlayerFactory;
import com.plmarket.factory.TeamFactory;
import com.plmarket.repository.PlayerRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player api tests.
 *
 * @author SShankunas
 */
@Transactional
public class PlayerCommissionServiceTests implements CommissionServiceBootApplicationTests {

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerCommissionService commissionService;

    @Test
    public void commissionTest() {
        Team team = TeamFactory.create("Test team", BigDecimal.valueOf(10));
        Player player = PlayerFactory.create("New test model",
                LocalDate.now().minus(20, ChronoUnit.MONTHS),
                LocalDate.now().minus(20, ChronoUnit.YEARS),
                team);
        player.id(UUID.randomUUID());
        when(playerRepository.findById(player.id())).thenReturn(Optional.of(player));
        BigDecimal calculate = commissionService.calculate(player.id());
        Assertions.assertEquals(BigDecimal.valueOf(40000000, 2), calculate);
        reset(playerRepository);
    }

    @Test
    public void commissionWithoutTeamTest() {
        Player player = PlayerFactory.create("New test model", LocalDate.now(), LocalDate.now(), null);
        player.id(UUID.randomUUID());
        when(playerRepository.findById(player.id())).thenReturn(Optional.of(player));
        BigDecimal calculate = commissionService.calculate(player.id());
        Assertions.assertEquals(BigDecimal.ZERO, calculate);
        reset(playerRepository);
    }

}
