package empresa.todoapi.dto

import empresa.todoapi.model.Status

data class UpdateStatusRequest(
    val status: Status
)