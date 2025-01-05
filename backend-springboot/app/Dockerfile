# Use a multi-stage build to keep the final image small
# Stage 1: Build the Spring Boot application
FROM gradle:7.6-jdk17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle project files to the container
COPY . .

# Build the Spring Boot application
RUN gradle clean build -x test

# Stage 2: Create the runtime container for Spring Boot application
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port for Spring Boot application (default 8080)
EXPOSE 8080

# Expose the ports for Kafka and Zookeeper
EXPOSE 2181 9092

# Use environment variables for Spring Boot database configuration
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL} \
    SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME} \
    SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Set Kafka and Zookeeper environment variables
ENV KAFKA_HOME=/opt/kafka
ENV ZOOKEEPER_MAXBUFFER=10485760
ENV PATH="${KAFKA_HOME}/bin:${PATH}"

# Install Kafka and Zookeeper
RUN apt-get update && apt-get install -y wget && \
    wget https://downloads.apache.org/kafka/3.9.0/kafka_2.13-3.9.0.tgz && \
    tar -xvzf kafka_2.13-3.9.0.tgz && \
    mv kafka_2.13-3.9.0 /opt/kafka && \
    rm kafka_2.13-3.9.0.tgz

# Run Kafka and Zookeeper using shell script in the background and Spring Boot application
ENTRYPOINT ["sh", "-c", "sed -i 's/^# maxBuffer=.*/maxBuffer=${ZOOKEEPER_MAXBUFFER}/' /opt/kafka/config/zookeeper.properties && \
    bin/zookeeper-server-start.sh config/zookeeper.properties & \
    bin/kafka-server-start.sh config/server.properties & \
    java -jar app.jar"]
