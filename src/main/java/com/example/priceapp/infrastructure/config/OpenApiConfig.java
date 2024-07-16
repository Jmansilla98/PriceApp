package com.example.priceapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

        @Bean
        public OpenAPI springShopOpenAPI() {
                return new OpenAPI()
                                .info(new Info().title("Pricing API")
                                                .description("API for pricing service")
                                                .version("v1.0")
                                                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                                .externalDocs(new ExternalDocumentation()
                                                .description("Pricing API Documentation")
                                                .url("https://example.com"));
        }
}
