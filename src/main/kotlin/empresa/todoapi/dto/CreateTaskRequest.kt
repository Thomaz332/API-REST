package empresa.todoapi.dto

import empresa.todoapi.model.Priority
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateTaskRequest(

    @field:NotBlank(message = "O título é obrigatório")
    @field:Size(min = 3, message = "O título deve ter no mínimo 3 caracteres")
    val title: String,

    val description: String?,

    @field:NotNull(message = "Prioridade é obrigatória")
    val priority: Priority
)

