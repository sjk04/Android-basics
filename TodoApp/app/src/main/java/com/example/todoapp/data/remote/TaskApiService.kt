package com.example.todoapp.data.remote


import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class TaskApiService(private val client: HttpClient) {

    private val BASE_URL = ""

    suspend fun getTasks(): List<TaskDto> {
        return client.get(BASE_URL).body()
    }

    suspend fun createTask(task: TaskDto) {
        client.post(BASE_URL) {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    suspend fun updateTask(task: TaskDto) {
        client.put("$BASE_URL/${task.id}") {
            contentType(ContentType.Application.Json)
            setBody(task)
        }
    }

    suspend fun deleteTask(id: String) {
        client.delete("$BASE_URL/$id")
    }
}