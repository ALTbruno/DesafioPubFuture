## Requisitos
+ [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
+ [PostgreSQL](https://www.postgresql.org/download/)
+ IDE (uso o [IntelliJ IDEA Community Edition](https://www.jetbrains.com/pt-br/idea/download/))
+ [Postman](https://www.postman.com/downloads)

## Como executar
1. Instale e configure as ferramentas acima
2. Abra o pgAdmin e crie o banco de dados: _db_gerenciadorfinanceiro_
3. Clone este repositório para sua máquina e abra com a IDE
4. Insira seu usuário e senha do PostgreSQL no arquivo application.properties
5. Execute a aplicação: _DesafioPubFutureApplication_
6. Abra o Postman e importe o arquivo _PubFuture.postman_collection_
7. Pronto! Você já pode fazer as requisições.

## Recursos da API

**CONTAS**

<span style="color:#ffd84f">POST</span> **/contas** \
Adiciona uma nova conta

<span style="color:#38d315">GET</span> **/contas** \
Lista todas as contas cadastradas

<span style="color:#38d315">GET</span> **/contas/{idConta}** \
Busca uma conta pelo ID

<span style="color:#4f6cff">PUT</span> **/contas/{idConta}** \
Atualiza uma conta pelo ID

<span style="color:#ea3b27">DELETE</span> **/contas/{idConta}** \
Apaga uma conta pelo ID

\
**RECEITAS**

<span style="color:#ffd84f">POST</span> **/receitas** \
Adiciona uma nova receita

<span style="color:#38d315">GET</span> **/receitas** \
Lista todas as receitas

<span style="color:#38d315">GET</span> **/receitas/{idReceita}** \
Busca uma receita pelo ID

<span style="color:#4f6cff">PUT</span> **/receitas/{idReceita}** \
Atualiza uma receita pelo ID

<span style="color:#ea3b27">DELETE</span> **/receitas/{idReceita}** \
Apaga uma receita pelo ID

<span style="color:#38d315">GET</span> **/receitas/tipo/{tipoReceita}** \
Lista receitas por Tipo

<span style="color:#38d315">GET</span> **/receitas/total** \
Retorna a soma de todas as receitas

<span style="color:#38d315">GET</span> **/receitas/conta/{idConta}/total** \
Retorna a soma de receitas de uma conta específica

<span style="color:#38d315">GET</span> **/receitas/data-recebimento/{dataInicial}/{dataFinal}** \
Retorna receitas com data de recebimento dentro do intervalo informado

<span style="color:#38d315">GET</span> **/receitas/data-recebimento-esperado/{dataInicial}/{dataFinal}** \
Retorna receitas com data de recebimento esperado dentro do intervalo informado

\
**DESPESAS**

<span style="color:#ffd84f">POST</span> **/despesas** \
Adiciona uma nova despesa

<span style="color:#38d315">GET</span> **/despesas** \
Lista todas as despesas

<span style="color:#38d315">GET</span> **/despesas/{idDespesa}** \
Busca uma despesa pelo ID

<span style="color:#4f6cff">PUT</span> **/despesas/{idDespesa}** \
Atualiza uma despesa pelo ID

<span style="color:#ea3b27">DELETE</span> **/despesas/{idDespesa}** \
Apaga uma despesa pelo ID

<span style="color:#38d315">GET</span> **/despesas/tipo/{tipoDespesa}** \
Lista despesas por Tipo

<span style="color:#38d315">GET</span> **/despesas/total** \
Retorna a soma de todas as despesas

<span style="color:#38d315">GET</span> **/despesas/conta/{idConta}/total** \
Retorna a soma de despesas de uma conta específica

<span style="color:#38d315">GET</span> **/despesas/data-pagamento/{dataInicial}/{dataFinal}** \
Retorna despesas com data de pagamento dentro do intervalo informado

<span style="color:#38d315">GET</span> **/despesas/data-pagamento-esperado/{dataInicial}/{dataFinal}** \
Retorna receitas com data de pagamento esperado dentro do intervalo informado
