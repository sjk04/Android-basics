package com.example.todoapp.ui.screens
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.viewmodel.TaskViewModel
import androidx.compose.runtime.setValue
import io.ktor.websocket.Frame




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    viewModel: TaskViewModel= viewModel()
)
{
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
        floatingActionButton =

}