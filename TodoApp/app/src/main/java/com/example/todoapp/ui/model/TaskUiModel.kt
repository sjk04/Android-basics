package com.example.todoapp.ui.model

data class TaskUiModel(
    val id: String,
    val title: String,
    val description: String,
    val dueDate: Long?,
    val isCompleted: Boolean
)
