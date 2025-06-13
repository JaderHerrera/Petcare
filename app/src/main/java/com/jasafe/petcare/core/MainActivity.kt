package com.jasafe.petcare.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jasafe.petcare.core.destination.MainScreen
import com.jasafe.petcare.core.presentation.theme.PetcareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetcareTheme {
                MainScreen()
            }
        }
    }
}