package empresa.todoapi.dto

import empresa.todoapi.model.Priority
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateTaskRequest(

    @field:NotBlank(message = "Título é obrigatório")
    val title: String,

    val description: String?,

    @field:NotNull(message = "Prioridade é obrigatória")
    val priority: Priority
)

