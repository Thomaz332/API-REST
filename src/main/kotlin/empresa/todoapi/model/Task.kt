package empresa.todoapi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tasks")
data class Task(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String,

    val description: String? = null,

    @Enumerated(EnumType.STRING)
    val priority: Priority,

    @Enumerated(EnumType.STRING)
    val status: Status = Status.PENDING,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime? = null
)
