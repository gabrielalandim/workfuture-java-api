# --- Estágio 1: Build (Usando Maven já instalado) ---
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# AQUI ESTÁ A MUDANÇA MÁGICA:
# Em vez de copiar arquivo por arquivo, copiamos TUDO (.) para dentro do container (.)
COPY . .

# Roda o build (gera o .jar)
RUN mvn -DskipTests clean package

# --- Estágio 2: Executar ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia os arquivos gerados para a pasta de deploy
COPY --from=build /app/target/quarkus-app/lib/ /deployment/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployment/
COPY --from=build /app/target/quarkus-app/app/ /deployment/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployment/quarkus/

# Inicia a API
CMD ["java", "-jar", "/deployment/quarkus-run.jar"]