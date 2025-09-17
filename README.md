# API de Gerenciamento de Cursos e Treinamentos

### Status: Projeto de Portfólio ✔️

API REST desenvolvida com **Java 17** e **Spring Boot 3** para gerenciar cursos, sessões de treinamento e a inscrição de participantes.

Este projeto foi originalmente criado como uma solução para um desafio técnico e, posteriormente, aprimorado e expandido para compor meu portfólio pessoal, demonstrando a aplicação de boas práticas de desenvolvimento backend.

---

## ✨ Funcionalidades Principais

-   **Gerenciamento de Cursos:** Operações CRUD (Criar, Ler, Atualizar, Deletar) para a entidade de cursos.
-   **Gerenciamento de Sessões de Treinamento:** Operações CRUD para as sessões, com associação direta a um curso existente.
-   **Gerenciamento de Participantes:** Operações CRUD para os participantes, com associação a uma sessão de treinamento específica.
-   **Validação de Dados:** Utilização da Bean Validation para garantir a integridade dos dados na camada de entrada da API.
-   **Tratamento Global de Exceções:** Implementação de um `ControllerAdvice` para capturar exceções e retornar respostas de erro padronizadas.

---

## 📐 Arquitetura e Conceitos Aplicados

-   **Arquitetura em Camadas:** O projeto segue uma estrutura bem definida, separando as responsabilidades em:
    -   `Controller`: Camada de entrada da API, responsável por gerenciar as requisições HTTP.
    -   `Service`: Camada de serviço, onde reside a lógica de negócio da aplicação.
    -   `Repository`: Camada de acesso a dados, utilizando Spring Data JPA.
-   **Padrão DTO (Data Transfer Object):** Uso de DTOs para desacoplar o modelo de dados interno da representação exposta na API, melhorando a segurança e a manutenibilidade.
-   **Injeção de Dependências:** Utilização intensiva do mecanismo de injeção de dependências do Spring para gerenciar os componentes da aplicação.
-   **Princípios RESTful:** Design da API seguindo as convenções e boas práticas do padrão REST.

---

## 🛠️ Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3**
-   **Spring Data JPA / Hibernate**
-   **Spring Web**
-   **PostgreSQL** (Banco de Dados)
-   **Maven** (Gerenciador de Dependências)
-   **Lombok**

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
-   [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
-   [Maven](https://maven.apache.org/download.cgi)
-   [PostgreSQL](https://www.postgresql.org/download/)

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd seu-repositorio
    ```

3.  **Configure o banco de dados:**
    -   Crie um banco de dados no PostgreSQL (ex: `course_db`).
    -   Abra o arquivo `src/main/resources/application.properties`.
    -   Altere as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` com as suas credenciais.

4.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

5.  A API estará disponível em `http://localhost:8080`.

---

## 📋 Endpoints da API

A API está documentada com todos os endpoints necessários para um gerenciamento completo das entidades.

### Cursos (`/courses`)

| Método | Endpoint                | Descrição                      |
| :----- | :---------------------- | :----------------------------- |
| `POST` | `/courses`              | Cria um novo curso.            |
| `GET`  | `/courses`              | Lista todos os cursos.         |
| `GET`  | `/courses/{id}`         | Busca um curso pelo seu ID.    |
| `PUT`  | `/courses/{id}`         | Atualiza um curso existente.   |
| `DELETE`| `/courses/{id}`         | Deleta um curso.               |

### Sessões de Treinamento (`/trainingsessions`)

| Método | Endpoint                      | Descrição                                  |
| :----- | :---------------------------- | :----------------------------------------- |
| `POST` | `/trainingsessions`           | Cria uma nova sessão de treinamento.       |
| `GET`  | `/trainingsessions`           | Lista todas as sessões.                    |
| `GET`  | `/trainingsessions/{id}`      | Busca uma sessão pelo seu ID.              |
| `PUT`  | `/trainingsessions/{id}`      | Atualiza uma sessão existente.             |
| `DELETE`| `/trainingsessions/{id}`      | Deleta uma sessão.                         |

### Participantes (`/participants`)

| Método | Endpoint                  | Descrição                           |
| :----- | :------------------------ | :---------------------------------- |
| `POST` | `/participants`           | Cria um novo participante.          |
| `GET`  | `/participants`           | Lista todos os participantes.       |
| `GET`  | `/participants/{id}`      | Busca um participante pelo seu ID.  |
| `PUT`  | `/participants/{id}`      | Atualiza um participante existente. |
| `DELETE`| `/participants/{id}`      | Deleta um participante.             |
