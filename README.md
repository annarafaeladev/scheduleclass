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
Scheduleclass
│
├── application        # Casos de uso, DTOs e exceções de aplicação
│   ├─ dto             # DTOs (ex.: ErrorResponseDTO)
│   ├─ exception       # Exceções da camada de aplicação
│   └─ usecase
│       ├─ academy
│       │   ├─ GetAcademyUseCase.java      # Interface do Use Case
│       │   └─ impl
│       │       └─ GetAcademyUseCaseImpl.java  # Implementação do Use Case
│       └─ student
│
├── config             # Configurações gerais e de Use Cases
│   └─ usecase
│       └─ AcademyUseCaseConfig.java
│
├── domain             # Domínio do negócio
│   ├─ enums           # Enums de negócio
│   ├─ exception       # Exceções de domínio (ex.: AcademyNotFoundException)
│   ├─ model           # Entidades do domínio (ex.: Academy, Student)
│   ├─ repository      # Interfaces de repositório
│   └─ service
│       ├─ AcademyService.java
│       └─ impl
│           └─ AcademyServiceImpl.java
│
├── infrastructure     # Implementações concretas e integrações externas
│   ├─ persistence
│   │   ├─ jpa         # Entities JPA (ex.: AcademyEntity)
│   │   └─ repository
│   │       ├─ AcademyJpaRepository.java
│   │       └─ impl
│   │           └─ AcademyRepositoryImpl.java
│   └─ swagger
│       └─ SwaggerConfig.java
│
└── web                # Controllers e handlers
    └─ controller
        ├─ AcademyController.java
        └─ GlobalExceptionHandler.java


```

---

### MODELO ENTIDADE RELACIONAMENTO DO BANCO
<img width="2144" height="1121" alt="Untitled (1)" src="https://github.com/user-attachments/assets/46a556c2-fdca-4bc5-9dd5-25213540d20b" />


# Referências

- [O Use Case: Modelando as Interações do Seu Domínio](https://medium.com/inside-picpay/o-use-case-modelando-as-intera%C3%A7%C3%B5es-do-seu-dom%C3%ADnio-c6c568270d0c)

