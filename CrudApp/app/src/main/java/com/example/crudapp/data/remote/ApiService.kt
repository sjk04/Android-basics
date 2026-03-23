package com.example.crudapp.data.remote

import com.example.crudapp.data.model.ApiObject
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class ApiService(private val client: HttpClient) {

    private val BASE_URL = "https://api.restful-api.dev/objects"

    suspend fun getAllItems(): List<ApiObject> {
        return client.get(BASE_URL).body()
    }

    suspend fun addObject(obj: ApiObject): ApiObject {
        return client.post(BASE_URL) {
            setBody(obj)
        }.body()
    }

    suspend fun updateObject(id: String, obj: ApiObject): ApiObject {
        return client.put("$BASE_URL/$id") {
            setBody(obj)
        }.body()
    }

    suspend fun deleteObject(id: String) {
        client.delete("$BASE_URL/$id")
    }
}