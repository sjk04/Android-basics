package com.example.crudapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.crudapp.data.model.ApiObject
import com.example.crudapp.ui.viewmodel.DeviceViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceScreen(viewModel: DeviceViewModel = koinViewModel()) {

    val objects by viewModel.uiState.collectAsState()
    var inputName by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Object Manager") }) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = inputName,
                    onValueChange = { inputName = it },
                    label = { Text("New Object Name") },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(8.dp))

                Button(onClick = {
                    if (inputName.isNotBlank()) {
                        viewModel.addObject(inputName)
                        inputName = ""
                    }
                }) {
                    Text("Add")
                }
            }

            LazyColumn {
                items(objects) { obj ->
                    ObjectItemRow(obj, viewModel)
                }
            }
        }
    }
}

@Composable
fun ObjectItemRow(
    obj: ApiObject,
    viewModel: DeviceViewModel
) {

    var showUpdateDialog by remember { mutableStateOf(false) }
    var editName by remember { mutableStateOf(obj.name) }

    if (showUpdateDialog) {
        AlertDialog(
            onDismissRequest = { showUpdateDialog = false },
            title = { Text("Update Object") },
            text = {
                TextField(
                    value = editName,
                    onValueChange = { editName = it }
                )
            },
            confirmButton = {
                Button(onClick = {
                    obj.id?.let { viewModel.updateObject(it, editName) }
                    showUpdateDialog = false
                }) { Text("Save") }
            },
            dismissButton = {
                TextButton(onClick = {
                    showUpdateDialog = false
                }) { Text("Cancel") }
            }
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = obj.name,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "ID: ${obj.id ?: "Pending"}",
                style = MaterialTheme.typography.bodySmall
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                TextButton(onClick = {
                    showUpdateDialog = true
                }) {
                    Text("Update")
                }

                TextButton(onClick = {
                    obj.id?.let { viewModel.deleteObject(it) }
                }) {
                    Text(
                        "Delete",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}