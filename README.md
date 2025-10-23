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
│   .gitignore
│   docker-compose.yml
│   Dockerfile
│   pom.xml
│   README.md
│   script-app-logs.sh
│   script-build.sh
│
└───src
    ├───main
    │   ├───java
    │   │   └───br
    │   │       └───com
    │   │           └───api
    │   │               └───scheduleclass
    │   │                       ScheduleclassApplication.java
    │   │
    │   └───resources
    │       │   application-docker.yml
    │       │   application-local.yml
    │       │   application.yml
    │       │   schema.sql
    │       │
    │       ├───static
    │       └───templates
    └───test
        └───java
            └───br
                └───com
                    └───api
                        └───scheduleclass
                                ScheduleclassApplicationTests.java
```


---

### MODELO ENTIDADE RELACIONAMENTO DO BANCO
