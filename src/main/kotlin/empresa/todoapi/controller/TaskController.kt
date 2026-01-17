package empresa.todoapi.controller

import empresa.todoapi.dto.TaskResponse
import empresa.todoapi.dto.UpdateStatusRequest
import empresa.todoapi.dto.CreateTaskRequest
import jakarta.validation.Valid
import empresa.todoapi.model.Task
import empresa.todoapi.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService
) {

    @PostMapping
    fun create(
        @Valid @RequestBody request: CreateTaskRequest
    ): ResponseEntity<TaskResponse> {
        val task = taskService.create(request)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(TaskResponse.fromEntity(task))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<TaskResponse>> {
        return ResponseEntity.ok(
            taskService.findAll().map { TaskResponse.fromEntity(it) }
        )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskResponse> {
        val task = taskService.findById(id)
        return ResponseEntity.ok(TaskResponse.fromEntity(task))
    }
 
    @PatchMapping("/{id}")
    fun updateStatus(
        @PathVariable id: Long,
        @RequestBody request: UpdateStatusRequest
    ): ResponseEntity<TaskResponse> {
        val updatedTask = taskService.updateStatus(id, request)
        return ResponseEntity.ok(TaskResponse.fromEntity(updatedTask))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        taskService.delete(id)
        return ResponseEntity.noContent().build()
    }


}
