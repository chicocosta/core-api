# Estágio 1: Build com Maven + JDK 21
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copia apenas o pom.xml primeiro para aproveitar o cache de camadas do Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código-fonte e gera o pacote .jar
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Execução leve apenas com JRE 21
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o .jar gerado da pasta target do estágio anterior
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

