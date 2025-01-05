# Use a multi-stage build to keep the final image small
# Stage 1: Build the application
FROM gradle:7.6-jdk17 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy project files to the container
COPY . .

# Build the application
RUN gradle clean build -x test

# Stage 2: Create the runtime container
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Install Kafka
RUN apt-get update && apt-get install -y wget && \
    wget https://downloads.apache.org/kafka/3.6.0/kafka_2.13-3.6.0.tgz && \
    tar -xvzf kafka_2.13-3.6.0.tgz && \
    mv kafka_2.13-3.6.0 /opt/kafka && \
    rm kafka_2.13-3.6.0.tgz

# Set Kafka home environment variable
ENV KAFKA_HOME=/opt/kafka
ENV PATH=$PATH:$KAFKA_HOME/bin

# Expose ports for the application and Kafka
EXPOSE 8080 9092

# Set environment variables for database configuration
ENV SPRING_DATASOURCE_URL=${SPRING_DATASOURCE_URL} \
    SPRING_DATASOURCE_USERNAME=${SPRING_DATASOURCE_USERNAME} \
    SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}

# Start Kafka and the Spring Boot application
CMD bash -c " \
    $KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties & \
    sleep 5 && \
    $KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties & \
    sleep 10 && \
    java -jar app.jar"
