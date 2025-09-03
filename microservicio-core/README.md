# Library Core - Configuraciones Compartidas ⚙️

## Descripción

El microservicio core es una librería compartida que proporciona configuraciones comunes para todos los microservicios de la biblioteca. Incluye configuraciones de seguridad, OpenAPI/Swagger y conversores de roles de Keycloak que son utilizados automáticamente por todos los demás servicios.

## Propósito

Este módulo centraliza las configuraciones comunes para:

- Evitar duplicación de código
- Mantener consistencia entre microservicios
- Facilitar el mantenimiento de configuraciones
- Aplicar estándares de seguridad uniformes

## Configuraciones Incluidas

### 1. OpenAPI Configuration

- **Clase**: `OpenApiConfig.class`
- **Función**: Configuración estándar de Swagger/OpenAPI para todos los microservicios
- **Características**:
  - Información general de la API
  - Configuración de seguridad OAuth2/JWT
  - Esquemas de autenticación
  - Metadata común de la documentación

### 2. Security Configuration

- **Clase**: `SecurityConfig.class`
- **Función**: Configuración de seguridad basada en OAuth2/JWT con Keycloak
- **Características**:
  - Configuración de JWT como Resource Server
  - Definición de endpoints públicos y protegidos
  - Configuración de CORS
  - Manejo de excepciones de seguridad

### 3. Keycloak Realm Role Converter

- **Clase**: `KeycloakRealmRoleConverter.class`
- **Función**: Convierte los roles de Keycloak en authorities de Spring Security
- **Características**:
  - Extrae roles del token JWT
  - Convierte roles de realm en authorities
  - Permite uso de `@PreAuthorize` con roles como ROLE_LIBRARIAN, ROLE_USER

## Auto-configuración

Todos los microservicios que incluyan esta dependencia automáticamente importarán todas las configuraciones sin necesidad de configuración adicional.

### Cómo se Aplica

```java
@AutoConfiguration
@Import({
    OpenApiConfig.class,
    SecurityConfig.class,
    KeycloakRealmRoleConverter.class
})
public class LibraryCoreAutoConfiguration {
    // Habilita importación automática de configuraciones
}
```

## Microservicios que Utilizan Core

- **microservicio-catalogo** (Puerto 8082)
- **microservicio-usuarios** (Puerto 8081)
- **microservicio-circulacion** (Puerto 8083)
- **microservicio-notificacion** (Puerto 8084)

## Tecnologías Incluidas

- Spring Boot Auto-Configuration
- Spring Security OAuth2 Resource Server
- SpringDoc OpenAPI (Swagger)
- Keycloak Spring Security Adapter
- JWT Token Processing

## Beneficios

- **Consistencia**: Todos los microservicios tienen la misma configuración de seguridad
- **Mantenimiento**: Cambios centralizados se propagan automáticamente
- **Reducción de código**: Elimina duplicación entre microservicios
- **Estándares**: Asegura que todos los servicios siguen las mismas prácticas

## Configuración de Keycloak

Cada microservicio debe configurar en su `application.properties`:

```properties
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8090/realms/library
keycloak.realm=library
keycloak.resource=[nombre-del-servicio]
keycloak.credentials.secret=[secreto-específico]
```

## Roles Soportados

- **ROLE_LIBRARIAN**: Acceso completo a todas las operaciones
- **ROLE_USER**: Acceso de solo lectura y operaciones limitadas
