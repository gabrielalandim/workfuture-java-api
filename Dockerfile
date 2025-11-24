# --- Estágio 1: Build ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copia tudo para dentro do container
COPY . .


RUN mvn -Dmaven.test.skip=true clean package

# --- Estágio 2: Executar ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia os arquivos gerados
COPY --from=build /app/target/quarkus-app/lib/ /deployment/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployment/
COPY --from=build /app/target/quarkus-app/app/ /deployment/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployment/quarkus/

# Inicia a API
CMD ["java", "-jar", "/deployment/quarkus-run.jar"]