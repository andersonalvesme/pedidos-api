[![Build Status](https://travis-ci.org/andersonalveson/pedidos-api.svg?branch=master)](https://travis-ci.org/andersonalveson/pedidos-api)

## Sobre o projeto

Projeto desenvolvido com o objetivo de auxiliar no aprendizado do framework Spring Boot com Java 8.

Para tal será criado uma API RESTful simples para Controle de Pedidos.

## Objetivos do projeto

- [ ] API de Pedidos
    - [x] Clientes
    - [x] Produtos
        - [ ] Categorias de produto
    - [ ] Pedidos
        - [ ] Itens do pedido
- [x] Integração contínua com TravisCI
- [x] Versionamento do banco de dados com FlyWay
- [x] Documentar API com Swagger
- [ ] Versionamento de API
- [ ] Autenticação com JWT
- [ ] Publicar a API no Heroku

## Configuração

### Ambiente
- docker-compose
    - jdk8
    - spring-boot-2
    - mysql

TravisCI

H2 para execução de testes

---

### Java

JDK - Java Development Kit

JRE - Maquina Virtual Java


### Spring Boot
- Spring Boot -> springCLI
	* spring-starter-web
	* spring-starter-data-jpa
	* spring-starter-mongodb
	
war
jar

Continuous integration using TravisCI


Swagger

http://localhost:8080/swagger-ui/#/basic-error-controller