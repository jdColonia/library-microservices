# Microservicio de Catálogo 📚

## Descripción

El microservicio de catálogo se encarga de gestionar el inventario de libros de la biblioteca. Permite consultar información de libros, verificar disponibilidad, actualizar el estado de disponibilidad y realizar búsquedas en el catálogo.

## Puerto del Servicio

- **Puerto**: 8082
- **URL Base**: http://localhost:8082

## Endpoints de la API

### 1. Obtener Libro por ID

- **Método**: `GET`
- **Endpoint**: `/books/{id}`
- **Descripción**: Recupera la información de un libro específico usando su identificador único
- **Autorización**: Requerida (LIBRARIAN o USER)
- **Inputs**:
  - `id` (Path Parameter): Identificador único del libro (ejemplo: "1")
- **Outputs**:
  - **200**: Objeto Book con información completa del libro
  - **404**: Libro no encontrado
  - **500**: Error interno del servidor

### 2. Verificar Disponibilidad de Libro

- **Método**: `GET`
- **Endpoint**: `/books/{id}/available`
- **Descripción**: Verifica si un libro específico está disponible para préstamo
- **Autorización**: Requerida (LIBRARIAN o USER)
- **Inputs**:
  - `id` (Path Parameter): Identificador único del libro (ejemplo: "1")
- **Outputs**:
  - **200**: Boolean indicando disponibilidad (true/false)
  - **404**: Libro no encontrado
  - **500**: Error interno del servidor

### 3. Actualizar Disponibilidad de Libro

- **Método**: `PUT`
- **Endpoint**: `/books/{id}/availability`
- **Descripción**: Actualiza el estado de disponibilidad de un libro (usado por el servicio de circulación)
- **Autorización**: Requerida (LIBRARIAN únicamente)
- **Inputs**:
  - `id` (Path Parameter): Identificador único del libro (ejemplo: "1")
  - `available` (Request Body): Nuevo estado de disponibilidad (true/false)
- **Outputs**:
  - **200**: Disponibilidad actualizada exitosamente
  - **400**: Estado de disponibilidad inválido
  - **404**: Libro no encontrado
  - **500**: Error interno del servidor

### 4. Buscar Libros

- **Método**: `GET`
- **Endpoint**: `/books/search`
- **Descripción**: Realiza búsquedas de libros basadas en criterios como título, autor u otros
- **Autorización**: Requerida (LIBRARIAN o USER)
- **Inputs**:
  - `criteria` (Query Parameter): Criterios de búsqueda (título, autor, etc.) (ejemplo: "Java")
- **Outputs**:
  - **200**: Lista de objetos Book que coinciden con los criterios
  - **400**: Criterios de búsqueda inválidos
  - **500**: Error interno del servidor

## Tecnologías Utilizadas

- Spring Boot
- Spring Security con OAuth2/JWT
- Spring Data JPA
- Base de datos H2 (en memoria)
- Swagger/OpenAPI para documentación
- Keycloak para autenticación y autorización

## Base de Datos

- **Tipo**: H2 (en memoria)
- **URL**: jdbc:h2:mem:catalogdb
- **Consola H2**: Habilitada en http://localhost:8082/h2-console

## Documentación API

- **Swagger UI**: http://localhost:8082/swagger-ui.html
- **API Docs**: http://localhost:8082/api-docs
