package com.iftm.exercicio02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Documentação da API sobre o Sistema Subscription")
                .version("Version 1 (v1)")
                .description("Esta documentação apresenta os endpoints " +
                        "responsáveis pelas funcionalidades de Usuários, " +
                        "Emails e Grupos de Usuários.")
                .termsOfService("http://mytersm.com")
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://mylicences.com"))
        );
    }
}