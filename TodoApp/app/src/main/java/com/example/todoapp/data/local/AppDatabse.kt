package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema=false

)

abstract class AppDatabse : RoomDatabase()
{
    abstract fun taskDao() : TaskDao
}