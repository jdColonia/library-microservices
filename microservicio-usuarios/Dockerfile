# Multi-stage Docker build for User Service

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy parent pom
COPY parent/pom.xml /app/parent/pom.xml

# Install parent POM to local repository
RUN cd /app/parent && mvn install -N

# Copy and install library-core
COPY microservicio-core/pom.xml /app/microservicio-core/pom.xml
COPY microservicio-core/src /app/microservicio-core/src
RUN cd /app/microservicio-core && mvn clean install -DskipTests

# Copy service pom and source
COPY microservicio-usuarios/pom.xml .
COPY microservicio-usuarios/src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
