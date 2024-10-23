# Use Eclipse Temurin JDK 21 as the base image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and the pom.xml file
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download the project dependencies
RUN ./mvnw dependency:go-offline

# Copy the project source code
COPY src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["./mvnw", "spring-boot:run"]