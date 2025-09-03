# Microservicio de Usuarios 👥

## Descripción

El microservicio de usuarios gestiona la información de los usuarios de la biblioteca. Permite consultar datos de usuarios y actualizar información personal como direcciones de correo electrónico.

## Puerto del Servicio

- **Puerto**: 8081
- **URL Base**: http://localhost:8081

## Endpoints de la API

### 1. Obtener Usuario por ID

- **Método**: `GET`
- **Endpoint**: `/users/{id}`
- **Descripción**: Recupera la información de un usuario específico usando su identificador único
- **Autorización**: Requerida (LIBRARIAN o USER)
- **Inputs**:
  - `id` (Path Parameter): Identificador único del usuario (ejemplo: "U001")
- **Outputs**:
  - **200**: Objeto User con información completa del usuario
  - **404**: Usuario no encontrado
  - **500**: Error interno del servidor

### 2. Actualizar Email del Usuario

- **Método**: `PUT`
- **Endpoint**: `/users/{id}/email`
- **Descripción**: Cambia la dirección de correo electrónico de un usuario específico. Los usuarios solo pueden actualizar su propio email
- **Autorización**: Requerida (LIBRARIAN o USER propietario)
- **Inputs**:
  - `id` (Path Parameter): Identificador único del usuario (ejemplo: "U001")
  - `newEmail` (Request Body): Nueva dirección de correo electrónico (ejemplo: "user@library.com")
- **Outputs**:
  - **200**: Email actualizado exitosamente
  - **400**: Formato de email inválido
  - **403**: Acceso denegado - solo puede actualizar su propio email
  - **404**: Usuario no encontrado
  - **500**: Error interno del servidor

## Modelo de Datos

El servicio maneja las siguientes entidades:

- **User**: Información del usuario (id, nombre, credenciales, email, dirección)
- **Email**: Dirección de correo electrónico
- **Address**: Dirección física del usuario
- **Credentials**: Credenciales de autenticación
- **UserId**: Identificador único del usuario

## Tecnologías Utilizadas

- Spring Boot
- Spring Security con OAuth2/JWT
- Spring Data JPA
- Base de datos H2 (en memoria)
- Swagger/OpenAPI para documentación
- Keycloak para autenticación y autorización

## Base de Datos

- **Tipo**: H2 (en memoria)
- **URL**: jdbc:h2:mem:usersdb
- **Consola H2**: Habilitada en http://localhost:8081/h2-console

## Seguridad

- Los usuarios pueden consultar su propia información
- Los bibliotecarios pueden consultar información de cualquier usuario
- Los usuarios solo pueden actualizar su propio email
- Los bibliotecarios pueden actualizar el email de cualquier usuario

## Documentación API

- **Swagger UI**: http://localhost:8081/swagger-ui.html
- **API Docs**: http://localhost:8081/api-docs
