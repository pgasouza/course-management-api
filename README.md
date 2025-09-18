# API de Gerenciamento de Cursos e Treinamentos

### Status: Projeto de Portfólio ✔️

API REST desenvolvida com **Java 21** e **Spring Boot 3** para gerenciar cursos, sessões de treinamento e a inscrição de participantes.

Este projeto foi originalmente criado como uma solução para um desafio técnico e, posteriormente, aprimorado e expandido para compor meu portfólio pessoal, demonstrando a aplicação de boas práticas de desenvolvimento backend e DevOps.

---

## ✨ Funcionalidades Principais

-   **Gerenciamento de Cursos:** Operações CRUD (Criar, Ler, Atualizar, Deletar) para a entidade de cursos.
-   **Gerenciamento de Sessões de Treinamento:** Operações CRUD para as sessões, com associação direta a um curso existente.
-   **Gerenciamento de Participantes:** Operações CRUD para os participantes, com associação a uma sessão de treinamento específica.
-   **Validação de Dados:** Utilização da Bean Validation para garantir a integridade dos dados na camada de entrada da API.
-   **Tratamento Global de Exceções:** Implementação de um `ControllerAdvice` para capturar exceções e retornar respostas de erro padronizadas.
-   **Containerização:** Aplicação e banco de dados totalmente containerizados com Docker, garantindo portabilidade e um ambiente de execução consistente.

---

## 📐 Arquitetura e Conceitos Aplicados

-   **Arquitetura em Camadas:** O projeto segue uma estrutura bem definida, separando as responsabilidades em:
    -   `Controller`: Camada de entrada da API, responsável por gerenciar as requisições HTTP.
    -   `Service`: Camada de serviço, onde reside a lógica de negócio da aplicação.
    -   `Repository`: Camada de acesso a dados, utilizando Spring Data JPA.
-   **Padrão DTO (Data Transfer Object):** Uso de DTOs para desacoular o modelo de dados interno da representação exposta na API.
-   **Injeção de Dependências:** Utilização intensiva do mecanismo de injeção de dependências do Spring.
-   **Princípios RESTful:** Design da API seguindo as convenções e boas práticas do padrão REST.

---

## 🛠️ Tecnologias Utilizadas

-   **Java 21**
-   **Spring Boot 3**
-   **Spring Data JPA / Hibernate**
-   **PostgreSQL**
-   **Docker** e **Docker Compose**
-   **Maven**
-   **Lombok**

---

## 🚀 Como Executar o Projeto

Existem duas maneiras de executar a aplicação:

### Método 1: Executando com Docker (Recomendado)

A maneira mais simples e recomendada de executar a aplicação e o banco de dados é utilizando o Docker Compose, que orquestra os containers de forma automática.

**Pré-requisitos:**
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/) (geralmente já vem com o Docker Desktop)

**Passos:**
1.  Clone este repositório.
2.  Na raiz do projeto (onde se encontra o arquivo `docker-compose.yml`), execute o seguinte comando no terminal:
    ```bash
    docker-compose up -d
    ```
3.  Aguarde os containers serem criados e iniciados. A API estará pronta para uso em `http://localhost:8080`.

*(Nota: Este método requer os arquivos `Dockerfile` e `docker-compose.yml` na raiz do projeto.)*

### Método 2: Executando Localmente

Para executar a aplicação diretamente na sua máquina, sem o Docker.

**Pré-requisitos:**
- [JDK 21](https://adoptium.net/temurin/releases/?version=21)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

**Passos:**
1.  Clone o repositório.
2.  Crie um banco de dados no seu PostgreSQL (ex: `course_db`).
3.  No arquivo `src/main/resources/application.properties`, altere as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` com suas credenciais.
4.  Navegue até a raiz do projeto e execute o comando:
    ```bash
    mvn spring-boot:run
    ```
5.  A API estará disponível em `http://localhost:8080`.

---

## 📋 Endpoints da API

A API fornece endpoints RESTful para o gerenciamento completo das entidades.

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
