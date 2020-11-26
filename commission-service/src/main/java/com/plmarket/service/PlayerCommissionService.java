package com.plmarket.service;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.NonNull;

/**
 * Commission service interface.
 *
 * @author SShankunas
 */
public interface PlayerCommissionService {

    BigDecimal calculate(@NonNull UUID playerId, int month);

}
