# O Desafio
O seu desafio nessa etapa será implementar uma solução que auxilie no controle das finanças pessoais. O foco é testar seus conhecimentos em **back-end**, e para isso você deve programar um sistema responsável por gerenciar as finanças pessoais.  

O sistema deve ser capaz de atender aos seguintes requisitos:

**Receitas**
* Cadastrar receitas
* Editar receitas
* Remover receitas
* Listar receitas
	+ Filtro por período (dataInicial – dataFinal)
	+ Filtro por tipo de receita
* Listar total de receitas

**Despesas**
* Cadastrar despesas
* Editar despesas
* Remover despesas
* Listar despesas
	+ Filtro por período (dataInicial – dataFinal)
	+ Filtro por tipo de despesa
* Listar total de despesas

**Contas**
* Cadastrar conta
* Editar conta
* Remover conta
* Listar contas
* Transferir saldo entre contas
* Listar saldo total


As **receitas** devem conter as seguintes informações:
* valor
* dataRecebimento
* dataRecebimentoEsperado
* descrição
* conta
* tipoReceita (salário, presente, prêmio, outros)
 
As **despesas** devem conter as seguintes informações:
* valor
* dataPagamento
* dataPagamentoEsperado
* tipoDespesa (alimentação, educação, lazer, moradia, roupa, saúde, transporte, outros)
* conta

As **contas** devem conter as seguintes informações:
* saldo
* tipoConta (carteira, conta corrente, poupança)
* instituicaoFinanceira

Para armazenar as informações utilize um banco de dados relacional de sua preferência. A linguagem de programação utilizada para implementar a solução também é opcional, porém a utilização de JAVA será um diferencial. Fique à vontade para utilizar bibliotecas e frameworks para auxiliar no desenvolvimento. Não se preocupe se não conseguir implementar todas as funcionalidades, sugerimos que você **priorize a qualidade no código**.
 

# O que será avaliado

**Requisitos obrigatórios:**
* Utilização de banco de dados relacional
* Documentação
* Controle de versionamento (Git e GitHub)

**Requisitos desejáveis:**
* Testes unitários
* Utilização de OOP
* Utilização de padrões de arquitetura (MVC, DDD, Microservices, etc.)   
* Solução desenvolvida no formato de uma REST API

A avaliação levará em conta os requisitos mencionados, a qualidade no código e a quantidade de funcionalidades implementadas.
 

# Envio da solução
1. A solução deve ser hospedada no GitHub e o link do repositório pode postado em sua área de candidato a partir de 06/01/22 (quinta-feira), com prazo máximo de entrega em 16/01/22 (domingo).
2. Para acessar sua área de candidato, acesse: https://pubfuture.com.br/inscricao/login - Campo Link do GitHub
3. O link deve ser similar a este: https://github.com/nomedeusuario/desafiopubfuture - crie um repositório exclusivo dentro do seu Github chamado "DesafioPubFuture" com a solução + um arquivo README.MD com as orientações necessárias para rodar a aplicação.
4. Soluções postadas após 16/01/2022 serão desconsideradas.