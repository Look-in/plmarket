package com.plmarket.config;

import com.plmarket.exception.RestResponseEntityExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Player service main configuration.
 *
 * @author SShankunas
 */
@Configuration
@Import({CommonWebConfig.class, RestResponseEntityExceptionHandler.class})
public class CommissionServiceConfig {
}
