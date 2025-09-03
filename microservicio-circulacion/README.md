# Microservicio de Circulación 🔄

## Descripción

El microservicio de circulación gestiona los préstamos y devoluciones de libros en la biblioteca. Se integra con el servicio de catálogo para verificar disponibilidad de libros y con el servicio de notificaciones para informar a los usuarios sobre sus préstamos.

## Puerto del Servicio

- **Puerto**: 8083
- **URL Base**: http://localhost:8083

## Endpoints de la API

### 1. Prestar Libro

- **Método**: `POST`
- **Endpoint**: `/circulation/loan`
- **Descripción**: Crea un nuevo registro de préstamo si el libro está disponible y envía notificación al usuario
- **Autorización**: Requerida (LIBRARIAN únicamente)
- **Inputs**:
  - `userId` (Query Parameter): Identificador único del usuario (ejemplo: "U001")
  - `bookId` (Query Parameter): Identificador único del libro (ejemplo: "1")
- **Outputs**:
  - **200**: Libro prestado exitosamente
  - **400**: ID de usuario o libro inválido
  - **403**: Acceso denegado - rol de bibliotecario requerido
  - **404**: Libro no encontrado o no disponible
  - **500**: Error interno del servidor

### 2. Devolver Libro

- **Método**: `POST`
- **Endpoint**: `/circulation/return`
- **Descripción**: Marca un préstamo como devuelto, actualiza la disponibilidad del libro y envía notificación
- **Autorización**: Requerida (LIBRARIAN únicamente)
- **Inputs**:
  - `loanId` (Query Parameter): Identificador único del préstamo (ejemplo: "L001")
- **Outputs**:
  - **200**: Libro devuelto exitosamente
  - **400**: ID de préstamo inválido
  - **403**: Acceso denegado - rol de bibliotecario requerido
  - **404**: Préstamo no encontrado
  - **500**: Error interno del servidor

### 3. Obtener Todos los Préstamos

- **Método**: `GET`
- **Endpoint**: `/circulation/loans`
- **Descripción**: Retorna una lista de todos los registros de préstamos. Los bibliotecarios pueden ver todos los préstamos
- **Autorización**: Requerida (LIBRARIAN o USER)
- **Inputs**: Ninguno
- **Outputs**:
  - **200**: Lista de objetos Loan con información de préstamos
  - **500**: Error interno del servidor

## Integraciones

- **Servicio de Catálogo**: Para verificar y actualizar disponibilidad de libros
- **Servicio de Notificaciones**: Para enviar notificaciones a usuarios sobre préstamos y devoluciones

## Tecnologías Utilizadas

- Spring Boot
- Spring Security con OAuth2/JWT
- Spring Data JPA
- OpenFeign para comunicación entre microservicios
- Base de datos H2 (en memoria)
- Swagger/OpenAPI para documentación
- Keycloak para autenticación y autorización

## Base de Datos

- **Tipo**: H2 (en memoria)
- **URL**: jdbc:h2:mem:circulationdb
- **Consola H2**: Habilitada en http://localhost:8083/h2-console

## Configuración Feign

- **Timeout de Conexión**: 5000ms
- **Timeout de Lectura**: 10000ms
- **Nivel de Log**: Full

## Documentación API

- **Swagger UI**: http://localhost:8083/swagger-ui.html
- **API Docs**: http://localhost:8083/api-docs
