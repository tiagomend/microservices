# Etapa 1: Imagem de build
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e outros arquivos de configuração do Maven
COPY pom.xml .

# Baixar as dependências do Maven (sem o código fonte ainda)
RUN mvn dependency:go-offline -B

# Copiar o código fonte da aplicação para o container
COPY src ./src

# Construir o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final
FROM openjdk:23-jdk-slim

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR da etapa de build para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Expor a porta da aplicação Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
