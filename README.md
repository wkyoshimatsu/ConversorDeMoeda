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
  O Conversor de Moeda é um projeto que permite conversões de moedas em tempo real, utilizando dados de uma API de taxas de câmbio.
</p>
<p align="justify">
 O sistema oferece um menu interativo via console para a escolha de pares de moedas, garantindo conversões precisas e atualizadas.
</p>

## :hammer: Funcionalidades

- :currency_exchange: Conversão de moedas: oferece ao usuário 6 opções de pares de conversão padrão além da opção customizada.
- :earth_americas: Atualização dinâmica das taxas de câmbio via API, garantindo dados precisos e em tempo real.
- :page_facing_up: Exibição de resultados: mostra ao usuário o valor convertido.

## :file_folder: Acesso ao projeto

Você pode acessar o [código fonte do projeto](https://github.com/wkyoshimatsu/ConversorDeMoeda/) ou [baixar o projeto](https://github.com/wkyoshimatsu/ConversorDeMoeda/archive/refs/heads/main.zip).

## :heavy_check_mark: Tecnologias utilizadas

- `Java 17`:
  > Linguagem de programação utilizada para o desenvolvimento do projeto, proporcionando robustez e portabilidade.

- `HttpClient, HttpRequest e HttpResponse`:
  >   Classe do Java utilizada para fazer requisições e obter respostas HTTP da API de taxas de câmbio

- `API de Taxas de Câmbio (ExchangeRateAPI)`:
  > Integração com APIs para obter taxas de câmbio atualizadas em tempo real (neste caso foi utilizado [ExchangeRate-API](https://www.exchangerate-api.com/).

- `JSON`:
  > Manipulação de dados no formato JSON para tratar as respostas da API de forma eficiente.

- `Gson`:
  > Biblioteca utilizada para manipulação de JSON na interação com a API de taxas de câmbio.

- `Maven`:
  > Utilizado como gerenciador de dependências e automação de compilação, facilitando a gestão do projeto.

- `Maven Compiler Plugin:`:
  > Plugin de compilação utilizado para configurar o processo de compilação, definindo o Java 17 e a codificação UTF-8.

- `Maven Shade Plugin:`:
  > Plugin usado para empacotar o projeto em um fat JAR, facilitando a execução em diferentes ambientes sem a necessidade de gerenciar manualmente as dependências.

## :books: Pré-requisitos

- Java 17 instalado.
- Maven configurado.
- Conexão com a internet.
- API_KEY da ExchangeRateAPI.
  - Para obter a chave de acesso, acesse o site [ExchangeRate-API](https://www.exchangerate-api.com/).


## :arrow_forward: Como rodar a aplicação

1. Clone o repositório do projeto ou [baixe o arquivo ZIP](https://github.com/wkyoshimatsu/ConversorDeMoeda/archive/refs/heads/main.zip):

```bash
git clone https://github.com/wkyoshimatsu/ConversorDeMoeda/
```

2. Entre na pasta do projeto:

```bash
cd ConversorDeMoeda-main
```
3. Configurar a API_KEY

O projeto depende de uma variável de ambiente chamada API_KEY (obtida no site [ExchangeRate-API](https://www.exchangerate-api.com/)).

Defina essa variável pelo terminal antes de rodar o projeto.

No Windows:

```bash
$env:API_KEY="sua-API_KEY"
```

No Linux/Mac:

```bash
export API_KEY="sua-API_KEY"
```


4. Execute o Maven para compilar o projeto:

```bash
mvn clean install
```

4. Execute a aplicação:

```bash
java -jar target/conversor-de-moeda-1.0-SNAPSHOT.jar
```

## :octocat: Desenvolvedores e Contribuintes

| [<img src="https://avatars2.githubusercontent.com/u/101765683?v=4" width=115><br><sub>Washington Yoshimatsu</sub>](https://github.com/wkyoshimatsu) | 
| :---: |
## :memo: Tarefas em aberto

:small_blue_diamond: Implementar histórico de conversões.

:small_blue_diamond: Implementar registro de logs.

:small_blue_diamond: Uso de alternativas ao ExchangeRateAPI.

---
Copyright :copyright: 2024 - Conversor de Moeda