package co.analisys.biblioteca.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI customOpenAPI(
                @Value("${spring.application.name:Library API}") String applicationName,
                @Value("${server.port:8080}") String serverPort) {
                return new OpenAPI()
                                .info(new Info()
                                                .title(applicationName + " - API")
                                                .description("REST API for digital library management with microservices")
                                                .version("1.0.0"))
                                .servers(List.of(
                                                new Server().url("http://localhost:" + serverPort)
                                                                .description("Local Development Server")));
        }
}
