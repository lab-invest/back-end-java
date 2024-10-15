FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21-jdk-slim

EXPOSE 8080

COPY --from=build /target/investLab-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]


#TODO - DÉBITO TÉCNICO - Validar horário e mandar 0 se for antes das 10
#TODO - Finalizar integração BFF com java
#TODO - ALTERAÇÃO DE USUÁRIO - Nome, foto de perfil
#TODO - Validar venda de ação - se ele tem a quantidade que quer vender e se vender tudo setar 0 e tirar da lista

##TODO: FEITO
##TODO - cotação de 8 ações mais famosas da bolsa - VALE, TRPL4, TAEE3, NEO3, TOTS3, GOAU4, KLBN11, PETR4 - 1
##TODO - Tela de previsão - 2
##TODO - Tela da ação - gráfico, cotação, infos, rentabilidade 12 meses - 2
##TODO - Atualizar rota de markeplace - mandar img
##TODO - Atualizar rota de marketplace - grafico de minuto a minuto
##TODO - Tela de pesquisa antes de pesquisar - Paginação de ações 12 em 12 - 2
#TODO - DÉBITO TÉCNICO - Decidir se os dados das ações serão de hoje
#TODO - Adicionar id firebase no banco
##TODO - tela de rentabilidade por carteira - gráfico - 5
##TODO - Tela da carteira - gráfico comparando as ações - 11
#TODO - Adicionar na carteira expecífica - 3
#TODO - Limpar perfil



##TODO: DOING
#TODO - DÉBITO TÉCNICO - Diminuir tempo de requisição da Stock Page

