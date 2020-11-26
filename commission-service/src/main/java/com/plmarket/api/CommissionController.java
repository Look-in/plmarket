package com.plmarket.api;

import com.plmarket.service.PlayerCommissionService;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Commission controller.
 *
 * @author SShankunas
 */
@RestController
@RequestMapping("/commission")
@RequiredArgsConstructor
public class CommissionController {

    private final PlayerCommissionService playerCommissionService;

    @GetMapping("/{id}")
    public BigDecimal calculate(@PathVariable UUID id) {
        return playerCommissionService.calculate(id);
    }

}
