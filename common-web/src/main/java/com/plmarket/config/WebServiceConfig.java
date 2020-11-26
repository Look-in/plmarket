package com.plmarket.config;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Web service configuration class.
 *
 * @author SShankunas
 */
@Configuration
public class WebServiceConfig {

    /**
     * Activates a Model Mapper.
     *
     * @return {@link ModelMapper}
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setSourceNamingConvention(NamingConventions.NONE)
                .setDestinationNamingConvention(NamingConventions.NONE)
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setPropertyCondition(context -> context.getSource() != null
                        && Hibernate.isInitialized(context.getSource()));
        return modelMapper;
    }

}
