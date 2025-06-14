package com.jasafe.petcare.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.jasafe.petcare.advices.presentation.AdvicesDestination
import com.jasafe.petcare.core.destination.HomeDestination
import com.jasafe.petcare.identification.presentation.IdentificationDestination
import com.jasafe.petcare.monitoring.presentation.MonitoringDestination
import com.jasafe.petcare.register.presentation.RegisterDestination
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
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
            startDestination = HomeRoute::class
    ) {
        composable<HomeRoute> { HomeDestination(navController = navController) }
        composable<IdentificationRoute> { IdentificationDestination() }
        composable<MonitoringRoute> { MonitoringDestination() }
        composable<AdvicesRoute> { AdvicesDestination() }
        composable<RegisterRoute> { RegisterDestination() }
    }
}

fun getNavOptions(
    navController: NavHostController
): NavOptions {
    return navOptions {
        popUpTo(navController.graph.findStartDestination().id) {}
        launchSingleTop = true // Lanzame una sola vez
    }
}

fun NavHostController.navigateToHome() {
     this.navigate(HomeRoute,getNavOptions(this))
}

fun NavHostController.navigateToIdentification(){
    this.navigate(IdentificationRoute,getNavOptions(this))
}

fun NavHostController.navigateToMonitoring(){
    this.navigate(MonitoringRoute,getNavOptions(this))
}

fun NavHostController.navigateToAdvices(){
    this.navigate(AdvicesRoute,getNavOptions(this))
}

fun NavHostController.navigateToRegister(){
    this.navigate(RegisterRoute,getNavOptions(this))
}