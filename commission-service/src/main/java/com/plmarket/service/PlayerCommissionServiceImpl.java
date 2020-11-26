package com.plmarket.service;

import com.plmarket.domain.Player;
import com.plmarket.domain.Team;
import com.plmarket.repository.PlayerRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Player Commission Service implementation.
 *
 * @author SShankunas
 */
@Service
@Transactional(readOnly = true)
public class PlayerCommissionServiceImpl implements PlayerCommissionService {

    @Setter(onMethod_ = {@Autowired})
    private PlayerRepository playerRepository;

    private static final BigDecimal COST = BigDecimal.valueOf(100000);

    @Override
    public BigDecimal calculate(@NonNull UUID playerId, int month) {
        Player player = playerRepository.findById(playerId).orElseThrow(IllegalArgumentException::new);
        BigDecimal playerCost = calculate(player, month);
        return Optional.ofNullable(player.team()).map(Team::commission).map(playerCost::multiply).orElse(playerCost);
    }

    private BigDecimal calculate(@NonNull Player player, int month) {
        return COST.multiply(BigDecimal.valueOf(month))
                .divide(BigDecimal.valueOf(player.age()),2, RoundingMode.DOWN);
    }

}
