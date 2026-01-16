package empresa.todoapi.controller

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
    fun create(@RequestBody task: Task): ResponseEntity<Task> {
        val createdTask = taskService.create(task)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(taskService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Task> {
        val task = taskService.findById(id)
        return ResponseEntity.ok(task)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        taskService.delete(id)
        return ResponseEntity.noContent().build()
    }
}
