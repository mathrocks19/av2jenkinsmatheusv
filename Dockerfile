# Etapa 1: Use uma imagem base do Maven para compilar o código
FROM maven:latest AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /av2jenkinsmatheusv

# Copie os arquivos do projeto Maven para o contêiner
COPY pom.xml .
COPY src ./src

# Execute a compilação e geração do arquivo .jar
RUN mvn clean package -DskipTests

# Etapa 2: Use uma imagem base do OpenJDK para rodar o aplicativo
FROM openjdk:20-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /av2jenkinsmatheusv

# Copie o arquivo .jar gerado na etapa anterior para o ambiente de execução
COPY --from=build /av2jenkinsmatheusv/target/*.jar av2jenkinsmatheusv.jar

# Exponha a porta que a aplicação Spring- Boot está configurada para usar
EXPOSE 8083

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "av2jenkinsmatheusv.jar"]