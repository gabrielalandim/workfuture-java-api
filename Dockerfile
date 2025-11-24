# --- Estágio 1: Build ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY . .

RUN echo "================= O QUE TEM NA PASTA? =================" && \
    ls -R /app && \
    echo "======================================================="

RUN mvn -Dmaven.test.skip=true clean package

# --- Estágio 2: Executar ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/quarkus-app/lib/ /deployment/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployment/
COPY --from=build /app/target/quarkus-app/app/ /deployment/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployment/quarkus/
CMD ["java", "-jar", "/deployment/quarkus-run.jar"]