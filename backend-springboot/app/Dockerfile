# Stage 1: Build the application using Gradle
FROM gradle:7.6-jdk17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy project files to the container
COPY . .

# Build the application (excluding tests to speed up the process)
RUN gradle clean build -x test

# Stage 2: Create the runtime container for Spring Boot app, Kafka, and Zookeeper
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the ports needed for Spring Boot, Zookeeper, and Kafka (9092 for Kafka, 8080 for Spring Boot, 2181 for Zookeeper)
EXPOSE 8080 9092 2181

# Install dependencies for Kafka and Zookeeper (wget to download and install Kafka)
RUN apt-get update && apt-get install -y wget && \
    wget https://downloads.apache.org/kafka/3.9.0/kafka_2.13-3.9.0.tgz && \
    tar -xvzf kafka_2.13-3.9.0.tgz && \
    mv kafka_2.13-3.9.0 /opt/kafka && \
    rm kafka_2.13-3.9.0.tgz

# Set environment variables for Zookeeper and Kafka
ENV ZOOKEEPER_CLIENT_PORT=2181
ENV KAFKA_LISTENER_SECURITY_PROTOCOL=PLAINTEXT
ENV KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
ENV KAFKA_LISTENER_PORT=9092
ENV KAFKA_ADVERTISED_LISTENER=PLAINTEXT://localhost:9092
ENV KAFKA_LISTENER_NAME=PLAINTEXT

# Start Zookeeper and Kafka, then the Spring Boot application
CMD /opt/kafka/bin/zookeeper-server-start.sh /opt/kafka/config/zookeeper.properties & \
    /opt/kafka/bin/kafka-server-start.sh /opt/kafka/config/server.properties & \
    java -jar app.jar
