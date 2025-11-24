# --- Estágio 1: Construção (Build) ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# 1. Copia APENAS o pom.xml primeiro (Isso ajuda a identificar se ele existe)
COPY pom.xml .

# 2. Copia a pasta de código fonte
COPY src ./src

# 3. Roda o Maven para gerar o .jar (Sem testes para ser rápido)
RUN mvn -DskipTests clean package

# --- Estágio 2: Execução (Run) ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia os arquivos gerados do estágio anterior para o local final
COPY --from=build /app/target/quarkus-app/lib/ /deployment/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployment/
COPY --from=build /app/target/quarkus-app/app/ /deployment/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployment/quarkus/

# Comando para iniciar o servidor
CMD ["java", "-jar", "/deployment/quarkus-run.jar"]