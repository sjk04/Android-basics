package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.ui.model.TaskUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID
class TaskViewModel : ViewModel()
{
    private val _tasks = MutableStateFlow<List<TaskUiModel>>(emptyList())
    val tasks: StateFlow<List<TaskUiModel>> = _tasks


    fun addTask(title:String,description: String,date:Long?)
    {
        val newTask = TaskUiModel(
            id = UUID.randomUUID().toString(),
            title = title,
            description = description,
            dueDate = date,
            isCompleted = false
        )
        _tasks.value=_tasks.value+newTask
    }

    fun deleteTask(task: TaskUiModel)
    {
        _tasks.value=_tasks.value - task
    }

    fun toggleComplete(task: TaskUiModel)
    {
        _tasks.value=_tasks.value.map{
            if(it.id==task.id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }

    fun updateTask(updated: TaskUiModel)
    {
        _tasks.value = _tasks.value.map {
            if (it.id == updated.id) updated else it
        }
    }

}





/*
package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.model.TaskUiModel
import com.example.todoapp.ui.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    viewModel: TaskViewModel = viewModel()
) {

    val tasks by viewModel.tasks.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredTasks = tasks.filter {
        it.title.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Tasks") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.addTask(
                        title = "New Task",
                        description = "Description",
                        date = null
                    )
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            // 🔍 Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search tasks") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            // 📋 Task List
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredTasks) { task ->
                    TaskItem(
                        task = task,
                        onToggle = { viewModel.toggleComplete(task) },
                        onDelete = { viewModel.deleteTask(task) },
                        onEdit = {
                            viewModel.updateTask(
                                task.copy(title = "Edited Task")
                            )
                        }
                    )
                }
            }
        }
    }
}
 */