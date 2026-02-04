package org.example.aprendeaiapi.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Estoque")
                        .version("1.0.0")
                        .description("API para gerenciar estoque de produtos")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Equipe de desenvolvimento")
                                .email("dev@swagger.io")
                                .url("http://swagger.io")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                );
    }
}
