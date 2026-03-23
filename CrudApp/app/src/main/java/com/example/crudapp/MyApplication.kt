package com.example.crudapp


import android.app.Application
import com.example.crudapp.data.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Logic: Initialize Koin with the blueprint we just wrote
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}