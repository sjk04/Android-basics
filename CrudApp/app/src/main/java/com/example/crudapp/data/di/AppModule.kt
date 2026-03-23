package com.example.crudapp.data.di

import com.example.crudapp.data.remote.ApiService
import com.example.crudapp.ui.viewmodel.DeviceViewModel
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true // Logic: Don't crash if API adds new fields
                })
            }


            defaultRequest {
                header("x-api-key", "69a980f4-e0b6-4a0c-9386-6890036b8088")
                contentType(ContentType.Application.Json)
            }
        }
    }
    single { ApiService(get()) }

    viewModel { DeviceViewModel(get()) }
}
