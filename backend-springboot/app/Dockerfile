# Use a multi-stage build to keep the final image small
# Stage 1: Build the application
FROM maven:3.8.6 AS builder
# Use OpenJDK 23 for the build environment
FROM openjdk:23-jdk-slim AS build-env
# Set the working directory inside the container
WORKDIR /app
# Copy project files to the container
COPY . .
# Set JAVA_HOME to ensure Maven uses the correct JDK version
ENV JAVA_HOME=/usr/lib/jvm/java-23-openjdk-amd64
# Build the application with OpenJDK 23 as the Java version
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime container
FROM openjdk:23-jdk-slim
# Set the working directory inside the container
WORKDIR /app
# Copy the built JAR file from the builder stage
COPY --from=build-env /app/target/*.jar app.jar
# Expose the port the application runs on
EXPOSE 8080
# Use environment variables for database configuration
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL} \
    SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME} \
    SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
