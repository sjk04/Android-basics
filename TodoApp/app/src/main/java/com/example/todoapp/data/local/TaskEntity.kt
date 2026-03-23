package com.example.todoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(

    @PrimaryKey
    val id: String,

    val title: String,

    val description: String,

    val dueDate: Long?,

    val isCompleted: Boolean,

    val isSynced: Boolean
)
