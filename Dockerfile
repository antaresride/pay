# Stage 1: Build the application
FROM eclipse-temurin:25.0.2_10-jdk AS builder
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B
COPY . .
# Build for ARM64 (native on your runner)
RUN ./mvnw clean package -DskipTests -B

# Stage 2: Dev environment for Zed
FROM eclipse-temurin:25.0.2_10-jdk AS dev
WORKDIR /app
# Install git, ssh, and basic tools for Zed
RUN apt-get update && apt-get install -y --no-install-recommends \
    git \
    openssh-client \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*
# Copy dependencies
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B
# Copy source for development
COPY . .
# Install Zed-friendly tools
RUN ./mvnw install -DskipTests -B || true
CMD ["sleep", "infinity"]

# Stage 3: Final lightweight image
FROM eclipse-temurin:25.0.2_10-jre-alpine
WORKDIR /root/
COPY --from=builder /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
