# 🥋 ScheduleClass – Sistema de Agendamento de Aulas

Aplicação desenvolvida em **Spring Boot** com **PostgreSQL** e **pgAdmin**, executando em containers **Docker**.  
O objetivo do sistema é gerenciar o agendamento de aulas, permitindo o cadastro de academias, alunos e horários de treino.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **PostgreSQL 15**
- **pgAdmin 4**
- **Docker & Docker Compose**

---

## 🧰 Requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- (Opcional) [Git](https://git-scm.com/)

---
## Arquitetura Inicial
Este projeto segue os princípios da Clean Architecture, separando claramente as camadas de domain, application e infrastructure. As regras de negócio estão encapsuladas no domain, os casos de uso e serviços de aplicação ficam na camada application, enquanto a persistência e APIs externas são tratadas na camada infrastructure. Essa abordagem garante manutenibilidade, testabilidade e independência de frameworks, facilitando futuras evoluções do sistema

### Fluxo das camadas:

* Controller: adapter que recebe HTTP, transforma DTO e chama Use Case.

* Use Case: regra de aplicação (orquestra domain e repositórios).

* Domain: lógica de negócio pura.

```
Client HTTP -> Controller -> Use Case -> Domain (entidades & regras) 
                      ^ 
                      | 
                 Infrastructure (implementa interfaces chamadas pelo Use Case)


````
---

## 🧩 Subir a Aplicação

Na raiz do projeto, execute:

```bash
docker-compose up --build
```
ou 
```bash
docker-compose up -d
```

---
## ⚙️ Estrutura do Projeto

```
C:.
├───main
│   ├───java
│   │   └───br
│   │       └───com
│   │           └───api
│   │               └───scheduleclass
│   │                   ├───application
│   │                   │   ├───common
│   │                   │   ├───dto
│   │                   │   │   └───academy
│   │                   │   ├───exception
│   │                   │   ├───repository
│   │                   │   └───usecase
│   │                   │       ├───academy
│   │                   │       │   └───impl
│   │                   │       └───student
│   │                   ├───config
│   │                   │   └───usecase
│   │                   ├───domain
│   │                   │   ├───enums
│   │                   │   ├───exception
│   │                   │   ├───model
│   │                   │   └───serivce
│   │                   │       └───impl
│   │                   ├───infrastructure
│   │                   │   ├───persistence
│   │                   │   │   ├───jpa
│   │                   │   │   └───repository
│   │                   │   │       └───impl
│   │                   │   └───swagger
│   │                   └───web
│   │                       ├───controller
│   │                       ├───dto
│   │                       │   ├───academy
│   │                       │   └───errors
│   │                       └───handler
│   └───resources
│       └───db
│           └───migration

```

---

### MODELO ENTIDADE RELACIONAMENTO DO BANCO
<img width="2144" height="1121" alt="Untitled (1)" src="https://github.com/user-attachments/assets/46a556c2-fdca-4bc5-9dd5-25213540d20b" />


# Referências

- [O Use Case: Modelando as Interações do Seu Domínio](https://medium.com/inside-picpay/o-use-case-modelando-as-intera%C3%A7%C3%B5es-do-seu-dom%C3%ADnio-c6c568270d0c)

