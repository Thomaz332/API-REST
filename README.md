# 📌 Todo API – Spring Boot com Kotlin

API REST simples para gerenciamento de tarefas (To-Do), desenvolvida com **Spring Boot 3**, **Kotlin** e **Spring Data JPA**, utilizando banco de dados **H2 em memória**.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Kotlin**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database (em memória)**
- **Maven**
- **Bean Validation**

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
- `status` (Enum: PENDING, COMPLETED)
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

### 🔹 Listar Task

**GET** `/tasks`

Resposta `200 OK`

Lista todas as tasks

**GET** `/tasks/{id}`

Lista uma task especifica

Resposta `200 OK`

### 🔹 Atualizar Task

**PATCH** `/tasks/{id}`

Atualiza o status de uma task

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

No terminal

`git clone https://github.com/Thomaz332/API-REST.git`

`cd todoapi`

`.\mvnw.cmd spring-boot:run`

A aplicação estará disponível em:

`http://localhost:8080`

Os endpoints podem ser testados utiizando o Postman
