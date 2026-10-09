package com.ghilea.cryptotrading.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI 3 / Swagger documentation configuration.
 *
 * @author Dan Lucian Ghilea
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cryptoTradingOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Crypto Trading and Wallet Platform REST API")
                .description("Enterprise REST API backend for cryptocurrency trading, wallet management, balance adjustments, and audit logging.")
                .version("v1.0.0")
                .contact(new Contact()
                    .name("Dan Lucian Ghilea")
                    .email("danlucianghilea@gmail.com")
                    .url("https://linkedin.com/in/lucian-ghilea"))
                .license(new License().name("MIT License")));
    }
}
