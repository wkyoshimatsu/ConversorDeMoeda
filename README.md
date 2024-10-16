<h1 align="center">Conversor de Moeda</h1>

<p align="center">
  <img src="https://img.shields.io/static/v1?label=&message=Java&color=gray&style=for-the-badge&logo=oracle"/>
  <img src="https://img.shields.io/static/v1?label=&message=Maven&color=gray&style=for-the-badge&logo=apachemaven"/>
  <img src="https://img.shields.io/static/v1?label=&message=gson&color=gray&style=for-the-badge&logo=google"/>
  <img src="https://img.shields.io/static/v1?label=&message=json&color=gray&style=for-the-badge&logo=json"/>
  <img src="https://img.shields.io/static/v1?label=&message=API&color=gray&style=for-the-badge&logo="/>
  <img src="https://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=red&style=for-the-badge"/>
</p>

## :mag: Índice

:small_blue_diamond: [Descrição do projeto](#pushpin-descrição-do-projeto)  
:small_blue_diamond: [Funcionalidades](#hammer-funcionalidades)  
:small_blue_diamond: [Acesso ao Projeto](#file_folder-acesso-ao-projeto)  
:small_blue_diamond: [Tecnologias utilizadas](#heavy_check_mark-tecnologias-utilizadas)  
:small_blue_diamond: [Pré-requisitos](#books-pré-requisitos)  
:small_blue_diamond: [Como rodar a aplicação](#arrow_forward-como-rodar-a-aplicação)  
:small_blue_diamond: [Desenvolvedores e Contribuintes](#octocat-desenvolvedores-e-contribuintes)  
:small_blue_diamond: [Tarefas em aberto](#memo-tarefas-em-aberto)

## :pushpin: Descrição do projeto

<p align="justify">
  O Conversor de Moeda é um desafio emocionante de programação, onde o objetivo é permitir aos usuários realizar conversões de moedas em tempo real, utilizando dados dinâmicos obtidos de uma API de taxas de câmbio. O sistema oferece interatividade via console, com um menu de opções para escolher entre diferentes pares de moedas, garantindo uma experiência precisa e atualizada. O projeto foi desenvolvido em Java, com foco no consumo de APIs e manipulação de dados JSON.
</p>

## :hammer: Funcionalidades

- :currency_exchange: Conversão de moedas: oferece ao usuário 6 opções de conversão entre diferentes moedas.
- :earth_americas: Atualização dinâmica das taxas de câmbio via API, garantindo dados precisos e em tempo real.
- :page_facing_up: Exibição de resultados: mostra ao usuário o valor convertido.
- :clipboard: Histórico de conversões: possibilidade de rastrear as últimas conversões realizadas (em desenvolvimento).

## :file_folder: Acesso ao projeto

Você pode acessar o [código fonte do projeto](https://github.com/exemplo/conversor-de-moeda) ou [baixar o projeto](https://github.com/exemplo/conversor-de-moeda/archive/refs/heads/main.zip).

## :heavy_check_mark: Tecnologias utilizadas

- `Java 17`:
  > Linguagem principal utilizada no desenvolvimento da aplicação.

- `Maven`:
  > Gerenciador de dependências e build do projeto.

- `Gson`:
  > Biblioteca utilizada para manipulação de JSON na interação com a API de taxas de câmbio.

- `API de Taxas de Câmbio`:
  > API usada para obter as taxas de câmbio mais recentes e realizar as conversões.

## :books: Pré-requisitos

- Java 17 instalado.
- Maven configurado.

## :arrow_forward: Como rodar a aplicação

1. Clone o repositório:

```bash
git clone https://github.com/exemplo/conversor-de-moeda
```

2. Entre na pasta do projeto:
```bash
cd conversor-de-moeda
```
3. Execute o Maven para compilar o projeto:
```bash
mvn clean install
```
4. Execute a aplicação:
```bash
mvn exec:java
```
:octocat: Desenvolvedores e Contribuintes
<img src="https://avatars.githubusercontent.com/u/000000?v=4" width=115><br><sub>Nome do Desenvolvedor</sub>
:memo: Tarefas em aberto
:small_blue_diamond: Implementar histórico de conversões.
:small_blue_diamond: Adicionar suporte para mais pares de moedas.
:small_blue_diamond: Melhorar a interface textual.
Copyright :copyright: 2024 - Conversor de Moeda