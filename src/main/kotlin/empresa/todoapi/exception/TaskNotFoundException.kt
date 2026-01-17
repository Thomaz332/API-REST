package empresa.todoapi.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.http.converter.HttpMessageNotReadableException
import java.time.LocalDateTime

class TaskNotFoundException(
    message: String
) : RuntimeException(message)

@RestControllerAdvice
class TaskExceptionHandler {

    // Trata erro de task nao encontrada
    @ExceptionHandler(TaskNotFoundException::class)
    fun handleTaskNotFound(ex: TaskNotFoundException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            timestamp = LocalDateTime.now(),
            status = 404,
            error = "Not Found",
            message = ex.message ?: "Task não encontrada"
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }
    
    // Trata erro de validação 
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(ex: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult.fieldErrors
            .joinToString(", ") { "${it.field}: ${it.defaultMessage}" }

        val error = ErrorResponse(
            timestamp = LocalDateTime.now(),
            status = 400,
            error = "Bad Request",
            message = message
        )

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    // Trata erro de conversão
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleInvalidJson(ex: HttpMessageNotReadableException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            timestamp = LocalDateTime.now(),
            status = 400,
            error = "Bad Request",
            message = "JSON inválido ou valor incorreto"
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }
}

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String
)
