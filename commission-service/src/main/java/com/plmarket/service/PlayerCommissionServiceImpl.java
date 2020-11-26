package com.plmarket.service;

import com.plmarket.domain.Player;
import com.plmarket.repository.PlayerRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player Commission Service implementation.
 *
 * @author SShankunas
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerCommissionServiceImpl implements PlayerCommissionService {

    private final PlayerRepository playerRepository;

    private static final BigDecimal COST = BigDecimal.valueOf(100000);

    @Override
    public BigDecimal calculate(@NonNull UUID playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(IllegalArgumentException::new);
        if (player.team() == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal playerCost = calculate(player);
        return playerCost.multiply(player.team().commission());
    }

    private BigDecimal calculate(Player player) {
        int age = Period.between(player.birthday(), LocalDate.now()).getYears();
        int contractMonth = Period.between(player.contractDate(), LocalDate.now()).getMonths();
        return COST.multiply(BigDecimal.valueOf(contractMonth))
                .divide(BigDecimal.valueOf(age), 2, RoundingMode.DOWN);
    }

}
