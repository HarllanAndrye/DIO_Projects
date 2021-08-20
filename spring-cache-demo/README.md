
## Utilizando Cache com Spring Boot

![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/-Spring_Boot-333333?style=flat&logo=spring)
![Apache Maven](https://img.shields.io/badge/-Apache_Maven-333333?style=flat&logo=apache-maven&logoColor=C71A36)
![Redis](https://img.shields.io/badge/-Redis-333333?style=flat&logo=redis)
![Docker](https://img.shields.io/badge/-Docker-333333?style=flat&logo=docker)

Este projeto foi feito baseado nas aulas da Digital Innovation One, com o título: Utilizando Cache para aumentar a performance da sua aplicação em dias de grande volume de acessos.

- Não foi utilizado banco de dados. Os dados estão fixos no código para simular o retorno de uma consulta ao BD;
- O objetivo foi mostrar como utilizar o cache para melhorar a performance;
- Foi utilizado o [redis](https://redis.io/) para armazenar o cache.

Tipos de cache:

- [ ] Local
- [x] Distribuído
    - [x] Redis
    - [ ] Memcached
    - [ ] ElastiCache
    - [ ] Hazelcast

> Foi utilizado o padrão Cache A-Side.


### Docker
---
O Redis foi instalado no Docker.

Para [instalar o docker compose](https://docs.docker.com/compose/install/) use os seguintes comandos:

```
$ sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

$ sudo chmod +x /usr/local/bin/docker-compose

$ docker-compose --version
```

No projeto, na pasta "docker", para instalar o Redis execute:

```
$ docker-compose up --build -d
```

Outros comandos Docker:
    
    Verificar os serviços rodando
        $ docker ps

    Parar e remover os containers
        $ docker-compose down


### :computer: Rodar a aplicação
---

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
$ mvn spring-boot:run
```

Após executar o comando acima, os seguintes endereços da API estarão disponíveis:

```
http://localhost:8080/products
http://localhost:8080/cache
```

Ao acessar `/cache`, o cache será removido do redis.

