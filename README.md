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

Infrastructure: implementação concreta de repositórios, JPA, serviços externos.
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
├───src
│   ├───main
│   │   ├───java
│   │   │   └───br
│   │   │       └───com
│   │   │           └───api
│   │   │               └───scheduleclass
│   │   │                   │   ScheduleclassApplication.java
│   │   │                   │
│   │   │                   ├───application
│   │   │                   │   ├───dto
│   │   │                   │   ├───exception
│   │   │                   │   └───usecase
│   │   │                   ├───domain
│   │   │                   │   ├───exception
│   │   │                   │   ├───model
│   │   │                   │   │       Academy.java
│   │   │                   │   │       Belt.java
│   │   │                   │   │       Booking.java
│   │   │                   │   │       ClassSchedule.java
│   │   │                   │   │       Instructor.java
│   │   │                   │   │       Plan.java
│   │   │                   │   │       Student.java
│   │   │                   │   │
│   │   │                   │   ├───repository
│   │   │                   │   └───serivce
│   │   │                   ├───infrastructure
│   │   │                   │   └───persistence
│   │   │                   │       ├───jpa
│   │   │                   │       │       AcademyEntity.java
│   │   │                   │       │       BaseEntity.java
│   │   │                   │       │       BeltEntity.java
│   │   │                   │       │       BookingEntity.java
│   │   │                   │       │       ClassScheduleEntity.java
│   │   │                   │       │       InstructorEntity.java
│   │   │                   │       │       PlanEntity.java
│   │   │                   │       │       StudentEntity.java
│   │   │                   │       │
│   │   │                   │       └───repository
│   │   │                   └───web
│   │   └───resources
│   │       │   application-docker.yml
│   │       │   application-local.yml
│   │       │   application.yml
│   │       │
│   │       └───db
│   │           └───migration
│   │                   V1__init_schema.sql
│   │                   V2__add_created_updated_columns.sql
│   │                   V3__alter_default_boolean.sql
│   │
│   └───test
│       └───java
│           └───br
│               └───com
│                   └───api
│                       └───scheduleclass
│                               ScheduleclassApplicationTests.java
```


---

### MODELO ENTIDADE RELACIONAMENTO DO BANCO
<img width="1563" height="1512" alt="ERD TO TABLE" src="https://github.com/user-attachments/assets/897730b4-a4aa-4016-bc1e-87a21d2cc173" />


