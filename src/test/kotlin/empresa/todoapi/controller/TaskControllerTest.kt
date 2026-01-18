package empresa.todoapi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import empresa.todoapi.dto.CreateTaskRequest
import empresa.todoapi.model.Priority
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    
    /Testa criação de uma task com sucesso
    
    @Test
    fun `deve criar uma task com sucesso`() {

        val request = CreateTaskRequest(
            title = "Estudar Testes",
            description = "Ver se funciona",
            priority = Priority.HIGH
        )

        mockMvc.post("/tasks") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(request)
        }
            .andExpect {
                status { isCreated() }
                jsonPath("$.id") { exists() }
                jsonPath("$.title") { value("Estudar Testes") }
                jsonPath("$.priority") { value("HIGH") }
                jsonPath("$.status") { value("PENDING") }
            }
    }

    /Testa listagem de tasks

    @Test
    fun `deve listar todas as tasks`() {

        mockMvc.get("/tasks")
            .andExpect {
                status { isOk() }
                jsonPath("$") { isArray() }
            }
    }

    /Testa erro ao buscar task inexistente
    @Test
    fun `deve retornar 404 quando task nao existir`() {

        mockMvc.get("/tasks/999")
            .andExpect {
                status { isNotFound() }
                jsonPath("$.message") { value("Task não encontrada") }
            }
    }
}
