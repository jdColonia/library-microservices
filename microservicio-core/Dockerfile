# Library Core Dockerfile
# Note: This is a library module, not a standalone service
# It should not be deployed independently but included as dependency in other microservices

FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy parent POM and install it first
COPY parent/pom.xml /app/parent/pom.xml
RUN cd /app/parent && mvn install -N

# Copy core module POM and source
COPY microservicio-core/pom.xml .
COPY microservicio-core/src ./src

# Build and install the library
RUN mvn clean install -DskipTests

# This library doesn't need a runtime stage as it's included in other services
# The JAR is now available in the local Maven repository for other builds