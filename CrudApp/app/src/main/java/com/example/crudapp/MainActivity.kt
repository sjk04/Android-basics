package com.example.crudapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.crudapp.ui.screens.DeviceScreen
import com.example.crudapp.ui.theme.CrudappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Logic: Allows the UI to go behind status/navigation bars
        enableEdgeToEdge()

        setContent {
            CrudappTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    DeviceScreen()
                }
            }
        }
    }
}