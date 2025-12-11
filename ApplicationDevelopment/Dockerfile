# 1. Build Stage: Use a standard Java 21 image
FROM eclipse-temurin:21-jdk-alpine as builder
WORKDIR /app
COPY . .
# Make the maven wrapper executable and build the jar
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# 2. Run Stage: Create a slim image for running the app
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy the built jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar
# Open port 8080
EXPOSE 8080
# Run the app
ENTRYPOINT ["java","-jar","app.jar"]