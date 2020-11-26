package com.plmarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * A common configuration class to importing into all web services.
 *
 * @author SShankunas
 */
@Configuration
@Import({SwaggerConfig.class, WebServiceConfig.class})
public class CommonWebConfig {
}
