FROM maven:3.8.6-eclipse-temurin-21 as build
WORKDIR /app
COPY . .
RUN mvn clean package -X -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build ./app/target/*.jar ./investlab.jar
ENTRYPOINT ["java", "-jar", "investlab.jar"]


##TODO - total wallet amount - 1
##TODO - tela de rentabilidade por carteira - gráfico - 5
##TODO - Tela de pesquisa antes de pesquisar - Paginação de ações 12 em 12 - 2
##TODO - Tela da ação - gráfico, cotação, infos, rentabilidade 12 meses - 2
##TODO - Tela da carteira - gráfico comparando as ações
#TODO - Adicionar na carteira expecífica -3


##TODO: FEITO
##TODO - cotação de 8 ações mais famosas da bolsa - VALE, TRPL4, TAEE3, NEO3, TOTS3, GOAU4, KLBN11, PETR4 - 1
