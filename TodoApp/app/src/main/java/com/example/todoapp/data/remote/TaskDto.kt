package com.example.todoapp.data.remote


import kotlinx.serialization.Serializable

@Serializable
data class TaskDto(
    val id: String,
    val title: String,
    val description: String,
    val dueDate: Long?,
    val isCompleted: Boolean
)