package com.jasafe.petcare.core.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jasafe.petcare.advices.presentation.AdvicesDestination
import com.jasafe.petcare.home.destination.HomeDestination
import com.jasafe.petcare.identification.presentation.IdentificationDestination
import com.jasafe.petcare.monitoring.presentation.MonitoringDestination
import com.jasafe.petcare.register.presentation.RegisterDestination
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

// Identificadores unicos de las pantallas (Cedulas)

@Serializable
data object HomeRoute

@Serializable
data object IdentificationRoute

@Serializable
data object MonitoringRoute

@Serializable
data object AdvicesRoute

@Serializable
data object RegisterRoute

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    drawerState: DrawerState,
) {
    val coroutine = rememberCoroutineScope()

    NavHost(
        navController = navHostController,
        startDestination = HomeRoute
    ) {
        composable<HomeRoute> {
            HomeDestination(
                navController = navHostController,
                onOpenDrawerState = {
                    coroutine.launch { drawerState.open() }
                }
            )
        }
        composable<IdentificationRoute> {
            IdentificationDestination(
                onOpenDrawerState = {
                    coroutine.launch { drawerState.open() }
                }
            )
        }
        composable<MonitoringRoute> { MonitoringDestination() }
        composable<AdvicesRoute> { AdvicesDestination() }
        composable<RegisterRoute> { RegisterDestination() }
    }
}