package co.analisys.biblioteca;

import co.analisys.biblioteca.config.KeycloakRealmRoleConverter;
import co.analisys.biblioteca.config.OpenApiConfig;
import co.analisys.biblioteca.config.SecurityConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Auto-configuration class for Library Core
 * Automatically imports all base configurations when the core library is included
 */
@AutoConfiguration
@Import({
    OpenApiConfig.class,
    SecurityConfig.class,
    KeycloakRealmRoleConverter.class
})
public class LibraryCoreAutoConfiguration {
    // This class enables automatic configuration import
    // All microservices that include the core dependency will automatically
    // get OpenAPI, Security and Keycloak configurations
}
