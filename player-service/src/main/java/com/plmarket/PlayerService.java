package com.plmarket;

import com.plmarket.config.PlayerServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@SpringBootApplication
@Import(PlayerServiceConfig.class)
public class PlayerService {

    public static void main(String[] args) {
        SpringApplication.run(PlayerService.class, args);
    }

}
