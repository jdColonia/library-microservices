# Multi-stage Docker build for Notification Service

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy parent pom first
COPY parent/pom.xml /app/parent/pom.xml

# Install parent POM to local repository
RUN cd /app/parent && mvn install -N

# Copy service pom and source
COPY microservicio-notificacion/pom.xml .
COPY microservicio-notificacion/src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/notification-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
