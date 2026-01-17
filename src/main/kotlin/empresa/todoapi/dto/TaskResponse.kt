package empresa.todoapi.dto

import empresa.todoapi.model.Priority
import empresa.todoapi.model.Status
import empresa.todoapi.model.Task
import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val priority: Priority,
    val status: Status,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime?
) {
    companion object {
        fun fromEntity(task: Task): TaskResponse {
            return TaskResponse(
                id = task.id!!,
                title = task.title,
                description = task.description,
                priority = task.priority,
                status = task.status,
                createdAt = task.createdAt,
                updatedAt = task.updatedAt
            )
        }
    }
}


