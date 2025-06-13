package com.jssdvv.petcare.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jssdvv.petcare.core.destination.MainScreen
import com.jssdvv.petcare.core.presentation.theme.PetcareTheme

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