package com.jasafe.petcare.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.jasafe.petcare.core.navigation.NavigationDrawer
import com.jasafe.petcare.core.presentation.theme.PetcareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetcareTheme {
                val navController = rememberNavController()

                NavigationDrawer(
                    navController = navController
                )
            }
        }
    }
}