package com.plmarket.api;

import com.plmarket.service.PlayerCommissionService;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommissionController {

    @Setter(onMethod_ = {@Autowired})
    private PlayerCommissionService playerCommissionService;

    @GetMapping("/player/{id}/month/{month}")
    public BigDecimal calculate(@PathVariable UUID id, @PathVariable int month) {
        if (month <= 0) {
            throw new IllegalArgumentException("The month must be positive");
        }
        return playerCommissionService.calculate(id, month);
    }

}
