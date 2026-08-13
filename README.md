# Book Registration API

API REST para cadastro e gerenciamento de livros, desenvolvida com Spring Boot, Spring Data JPA e MySQL. Permite listar, buscar, criar, atualizar (total ou parcialmente) e remover livros através de endpoints HTTP simples.

## Tecnologias usadas

- **Java 17+**
- **Spring Boot**
- **Spring Web** (REST)
- **Spring Data JPA**
- **MySQL**
- **Maven**

## Pré-requisitos

- Java 17 ou superior instalado
- MySQL rodando localmente (ou acessível pela rede)
- Maven não é obrigatório instalar globalmente — o projeto já inclui o Maven Wrapper (`mvnw` / `mvnw.cmd`)

## Como rodar o projeto localmente

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/book-registration.git
cd book-registration
```

### 2. Configurar o `application.properties`

O arquivo `src/main/resources/application.properties` contém credenciais locais e por isso não é versionado. Copie o arquivo de exemplo e ajuste os valores:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

Edite `src/main/resources/application.properties` com as credenciais do seu MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_crud
spring.datasource.username=root
spring.datasource.password=your_password_here
```

### 3. Criar o banco de dados

Crie o schema no MySQL (o nome deve bater com o configurado em `spring.datasource.url`):

```sql
CREATE DATABASE springboot_crud;
```

As tabelas são criadas automaticamente pelo Hibernate na primeira execução, graças à configuração `spring.jpa.hibernate.ddl-auto=update`.

### 4. Rodar a aplicação

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## Endpoints disponíveis

Base path: `/api/books`

| Método | Rota              | Descrição                          | Exemplo de body |
|--------|--------------------|-------------------------------------|------------------|
| GET    | `/api/books`       | Lista todos os livros cadastrados   | —                |
| GET    | `/api/books/{id}`  | Busca um livro pelo id              | —                |
| POST   | `/api/books`       | Cria um novo livro                  | `{ "name": "Clean Code", "note": 9.5 }` |
| PUT    | `/api/books/{id}`  | Atualiza um livro por completo (nome e nota) | `{ "name": "Clean Code", "note": 10.0 }` |
| PATCH  | `/api/books/{id}`  | Atualiza parcialmente um livro (apenas os campos enviados) | `{ "note": 8.0 }` |
| DELETE | `/api/books/{id}`  | Remove um livro pelo id             | —                |

### Modelo `Books`

```json
{
  "id": 1,
  "name": "Clean Code",
  "note": 9.5
}
```

## Sobre o projeto

Este projeto foi construído para consolidar conhecimento prático em APIs REST com Spring Boot — modelagem de entidade com JPA, repositórios com Spring Data, e um controller cobrindo o ciclo CRUD completo (incluindo a diferença entre atualização total via `PUT` e parcial via `PATCH`).
