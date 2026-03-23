package com.example.todoapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao{
    @Query("SELECT * from tasks ORDER BY dueDate ASC")
    fun getAllTasks(): Flow<List<TaskEntity>>


    @Query("SELECT * From tasks where title like '%' || :query || '%'")
    fun searchTasks (query: String):Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task : TaskEntity)

    @Update
    suspend fun update(task : TaskEntity)

    @Delete
    suspend fun delete(task :TaskEntity)
}




/*
package com.example.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
 */