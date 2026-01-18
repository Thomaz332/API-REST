# 📌 Todo API – Spring Boot com Kotlin

API REST simples para gerenciamento de tarefas (To-Do), desenvolvida com **Spring Boot 3**, **Kotlin** e **Spring Data JPA**, utilizando banco de dados **H2 em memória**.

## 💻 Tecnologias Utilizadas

- **Java 17**
- **Kotlin**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database (em memória)**
- **Maven**
- **Bean Validation**
- **JUnit / MockMvc (testes)**
- **Docker**
- **SwaggerUI**
---

## 📁 Estrutura do Projeto

```bash
src/
├── main/
│   ├── kotlin/
│   │   └── empresa/todoapi/
│   │       ├── TodoApiApplication.kt
│   │       ├── controller/
│   │       │   └── TaskController.kt
│   │       ├── service/
│   │       │   └── TaskService.kt
│   │       ├── repository/
│   │       │   └── TaskRepository.kt
│   │       ├── model/
│   │       │   ├── Task.kt
│   │       │   ├── Priority.kt
│   │       │   └── Status.kt
│   │       ├── dto/
│   │       │   ├── CreateTaskRequest.kt
│   │       │   ├── UpdateStatusRequest.kt
│   │       │   └── TaskResponse.kt
│   │       └── exception/
│   │           └── TaskNotFoundException.kt
│   └── resources/
│       └── application.yml
└── test/
    └── kotlin/
        └── empresa/todoapi/
            └── controller/
                └── TaskControllerTest.kt
```
## 📌 Modelo de Dados

### Task
- `id` (Long)
- `title` (String)
- `description` (String?)
- `priority` (Enum: LOW, MEDIUM, HIGH)
- `status` (Enum: PENDING, IN_PROGRESS, COMPLETED)
- `createdAt` (LocalDateTime)
- `updatedAt` (LocalDateTime?)

---

## 🔗 Endpoints da API

### 🔹 Criar Task

**POST** `/tasks`

```json
{
  "title": "Estudar Spring Boot",
  "description": "Criar API REST com Kotlin",
  "priority": "HIGH"
}
```

Resposta `201 Created`

### 🔹 Listar todas as task

**GET** `/tasks`

Resposta `200 OK`

### 🔹Listar task especifica

**GET** `/tasks/{id}`

Resposta `200 OK`

### 🔹 Atualizar status da task

**PATCH** `/tasks/{id}`

```json
{
  "status": "COMPLETED"
}
```

Resposta `200 OK`

### 🔹 Deletar Task

**DELETE** `/tasks/{id}`

Resposta `204 No Content`

## 🚀 Como executar o projeto

### No terminal

`git clone https://github.com/Thomaz332/API-REST.git`

`cd API-REST`

`docker build -t todo-api .`

`docker run -p 8080:8080 todo-api`

A aplicação estará disponível em:

`http://localhost:8080`

## ✨ Testes

Os endpoints podem ser testados utiizando Swagger UI ou Postman

Via Swagger UI após rodar o programa cole isso na barra de pesquisa do navegador

`http://localhost:8080/swagger-ui/index.html`

## 🧪 Testes Automatizados

O projeto possui testes automatizados para criação, listagem e erro em busca de task

### No terminal

`.\mvnw.cmd test`
