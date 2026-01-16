package empresa.todoapi

import empresa.todoapi.model.Priority
import empresa.todoapi.model.Task
import empresa.todoapi.service.TaskService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoapiApplication {

    @Bean
    fun test(taskService: TaskService) = CommandLineRunner {
        val task = Task(
            title = "Teste inicial",
            description = "Verificando se salva no banco",
            priority = Priority.HIGH
        )

        taskService.create(task)

        println("Tasks no banco:")
        taskService.findAll().forEach {
            println(it)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<TodoapiApplication>(*args)
}
