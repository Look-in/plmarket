package com.plmarket;

import com.plmarket.config.CommissionServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@SpringBootApplication
@Import(CommissionServiceConfig.class)
public class CommissionService {

    public static void main(String[] args) {
        SpringApplication.run(CommissionService.class, args);
    }

}
