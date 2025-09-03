# Microservicio de Notificaciones 📧

## Descripción

El microservicio de notificaciones se encarga de enviar notificaciones a los usuarios de la biblioteca. Es utilizado principalmente por el servicio de circulación para informar a los usuarios sobre préstamos, devoluciones y otros eventos relacionados con sus actividades en la biblioteca.

## Puerto del Servicio

- **Puerto**: 8084
- **URL Base**: http://localhost:8084

## Endpoints de la API

### 1. Enviar Notificación

- **Método**: `POST`
- **Endpoint**: `/notify`
- **Descripción**: Envía una notificación a un usuario específico. Solo los bibliotecarios pueden enviar notificaciones
- **Autorización**: Requerida (LIBRARIAN únicamente)
- **Inputs**:
  - `notification` (Request Body): Objeto NotificationDTO con los detalles de la notificación
- **Outputs**:
  - **200**: Notificación enviada exitosamente
  - **400**: Datos de notificación inválidos
  - **403**: Acceso denegado - rol de bibliotecario requerido
  - **500**: Error interno del servidor

## Modelo de Datos

El servicio utiliza las siguientes estructuras:

- **NotificationDTO**: Objeto de transferencia de datos que contiene:
  - Identificador del usuario destinatario
  - Mensaje de la notificación
  - Tipo de notificación
  - Timestamp de envío

## Casos de Uso

Este servicio es utilizado para notificar a los usuarios sobre:

- Confirmación de préstamos de libros
- Confirmación de devoluciones
- Recordatorios de vencimiento
- Avisos importantes de la biblioteca

## Integraciones

- **Servicio de Circulación**: Principal consumidor del servicio para notificaciones de préstamos y devoluciones
- **Potenciales integraciones futuras**: Email, SMS, push notifications

## Tecnologías Utilizadas

- Spring Boot
- Spring Security con OAuth2/JWT
- Base de datos H2 (en memoria)
- Swagger/OpenAPI para documentación
- Keycloak para autenticación y autorización

## Base de Datos

- **Tipo**: H2 (en memoria)
- **URL**: jdbc:h2:mem:notificationdb
- **Consola H2**: Habilitada en http://localhost:8084/h2-console

## Seguridad

- Solo los bibliotecarios pueden enviar notificaciones
- Las notificaciones se envían a usuarios específicos según su ID
- Autenticación y autorización manejada a través de Keycloak

## Documentación API

- **Swagger UI**: http://localhost:8084/swagger-ui.html
- **API Docs**: http://localhost:8084/api-docs
