package empresa.todoapi.service

import empresa.todoapi.exception.TaskNotFoundException
import empresa.todoapi.model.Task
import empresa.todoapi.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun create(task: Task): Task {
        return taskRepository.save(task)
    }

    fun findAll(): List<Task> {
        return taskRepository.findAll()
    }

    fun findById(id: Long): Task {
        return taskRepository.findById(id)
            .orElseThrow { TaskNotFoundException("Task não encontrada") }
    }

    fun delete(id: Long) {
        taskRepository.deleteById(id)
    }
}
