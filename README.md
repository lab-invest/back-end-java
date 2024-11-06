A InvestLab API é uma API desenvolvida em Java que simula o funcionamento de uma corretora de valores. Ela integra dados de cotações financeiras por meio de um serviço externo desenvolvido em Python, permitindo que você acesse informações atualizadas de preços e cotações de ativos no mercado.
Funcionalidades
A API InvestLab oferece os seguintes recursos:
Consulta de Cotações de Ativos: Através de uma integração com um serviço externo, você pode obter cotações de ativos financeiros em tempo real.
Simulação de Compras e Vendas: Simule operações de compra e venda de ações, criptomoedas, ou outros ativos financeiros.
Carteira de Investimentos: Acompanhe os ativos em sua carteira de investimentos.
Relatórios e Análises: Gere relatórios simples sobre o desempenho da sua carteira.
Como Funciona
A API foi construída em Java, utilizando frameworks modernos para oferecer alta performance e confiabilidade.
As cotações dos ativos são obtidas a partir de um serviço externo desenvolvido em Python, disponível na URL: https://investlab-bff.onrender.com/.
A API Java realiza as requisições ao serviço Python para buscar as cotações mais recentes e fornecer os dados necessários para a simulação das operações financeiras.
Endpoints
1. Buscar Usuario e suas Carteiras
URL: /user?uuid={uuid}
Método: GET
Descrição: Retorna as informações do usuario, como informações pessoais e informações sobre suas ações. A rota também atualiza os rendimentos do usuario
Parâmetros:
uuid (string): O código gerado ao criar o usuario.
2. Simulação de Compra de Ativo
URL: /stock/cotation?ticker={ticker}
Método: GET
Descrição: Recupera o atual valor de um ativo financeiro.
Como Rodar
Pré-requisitos
Java 11 ou superior
Maven (para gerenciamento de dependências)
JDK para compilar e rodar o código Java
Servidor Python para fornecer as cotações (disponível em https://investlab-bff.onrender.com/)
Instruções
Clone este repositório: git clone https://github.com/seu-usuario/investlab-api.gi
Navegue até o diretório do projeto: cd investlab-api
Compile o projeto utilizando o Maven: mvn clean install
Execute a aplicação: mvn spring-boot:run
A API estará disponível localmente em http://localhost:8080.
Tecnologias Usadas
Backend: Java (Spring Boot)
Serviço Externo: Python (https://investlab-bff.onrender.com)
Banco de Dados: MongoDB
API de Cotações: Yahoo Finance
