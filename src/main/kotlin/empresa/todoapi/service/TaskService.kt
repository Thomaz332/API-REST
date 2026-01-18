package empresa.todoapi.service

import empresa.todoapi.dto.UpdateStatusRequest
import empresa.todoapi.dto.CreateTaskRequest
import empresa.todoapi.model.Status
import empresa.todoapi.exception.TaskNotFoundException
import empresa.todoapi.model.Task
import empresa.todoapi.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun create(request: CreateTaskRequest): Task {
        val task = Task(
            title = request.title,
            description = request.description,
            priority = request.priority,
            status = Status.PENDING,
            createdAt = LocalDateTime.now()
        )
        return taskRepository.save(task)
    }

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }

    fun findById(id: Long): Task {
        return taskRepository.findById(id)
            .orElseThrow { TaskNotFoundException("Task não encontrada") }
    }

    fun updateStatus(id: Long, request: UpdateStatusRequest): Task {
        val task = findById(id)

        val updatedTask = task.copy(
            status = request.status,
            updatedAt = LocalDateTime.now()
        )

        return taskRepository.save(updatedTask)
    }

    fun delete(id: Long) {
        val task = findById(id) 
        taskRepository.delete(task)
    }
}