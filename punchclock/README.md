# API REST de controle de ponto


![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/-Spring_Boot-333333?style=flat&logo=spring)
![Apache Maven](https://img.shields.io/badge/-Apache_Maven-333333?style=flat&logo=apache-maven&logoColor=C71A36)
![Swagger](https://img.shields.io/badge/-Swagger-333333?style=flat&logo=swagger)
![PostgreSQL](https://img.shields.io/badge/-PostgreSQL-333333?style=flat&logo=postgresql)

Este projeto foi feito baseado nas aulas da Digital Innovation One, com o título: Construindo um sistema de controle de ponto e acesso com Spring Boot.

Projeto com:
- Java 11 (foi utilizado o openjdk-11);
- Maven;
- Spring Boot 2.5.2;
- Swagger UI 3.0;
- Banco de dados PostgreSQL.


> **Obs.**: Criar o banco de dados antes de iniciar a aplicação.
> 
> ``` CREATE DATABASE punchclock; ```


### :computer: Rodar a aplicação
---

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
$ mvn spring-boot:run
```

Após executar o comando acima, o seguinte endereço da API estará disponível:

```
http://localhost:8080/
```

Para visualizar os endpoints da API, usamos o Swagger UI, no endereço:

```
http://localhost:8080/swagger-ui/
```
