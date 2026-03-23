package com.example.crudapp.ui.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.crudapp.data.remote.ApiService
import androidx.lifecycle.viewModelScope
import com.example.crudapp.data.model.ApiObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DeviceViewModel(private val apiService: ApiService) : ViewModel() {
    private val _uiState = MutableStateFlow<List<ApiObject>>(emptyList())
    val uiState = _uiState.asStateFlow()

    init {
        fetchAllDevices()
    }

    fun fetchAllDevices() {
        viewModelScope.launch {
            try {
                val devices = apiService.getAllItems()
                _uiState.value = devices
            } catch (e: Exception) {
                // Logic: In a real app, you'd handle errors here
            }
        }
    }

    // 1. Logic: Add with a unique local ID
    fun addObject(name: String) {
        viewModelScope.launch {
            try {
                val newObject = ApiObject(
                    name = name,
                    data = null
                )

                val response = apiService.addObject(newObject)

                _uiState.value = listOf(response) + _uiState.value

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateObject(id: String, updatedName: String) {
        viewModelScope.launch {
            try {
                val updated = ApiObject(id = id, name = updatedName)

                apiService.updateObject(id, updated)

                _uiState.value = _uiState.value.map {
                    if (it.id == id) it.copy(name = updatedName) else it
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteObject(id: String) {
        viewModelScope.launch {
            try {
                apiService.deleteObject(id)
                _uiState.value = _uiState.value.filter { it.id != id }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}