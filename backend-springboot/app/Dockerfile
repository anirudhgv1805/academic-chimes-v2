# Use a multi-stage build to keep the final image small
# Stage 1: Build the application
FROM gradle:7.6.2-jdk21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy project files to the container
COPY . .

# Build the application
RUN gradle clean build -x test

# Stage 2: Create the runtime container
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Use environment variables for database configuration
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL} \
    SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME} \
    SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
