package com.jasafe.petcare.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.jasafe.petcare.core.presentation.navigation.AppNavItem
import com.jasafe.petcare.core.presentation.navigation.HomeRoute

@Composable
fun rememberAppState(
    navHostController: NavHostController = rememberNavController(),
) = remember(navHostController) { AppState(navHostController) }

@Stable
class AppState(
    val navHostController: NavHostController,
) {
    val currentNavDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val drawerNavItems = AppNavItem.entries

    fun navigateToDrawerItem(route: AppNavItem) {
        val options = navOptions {
            popUpTo(navHostController.graph.startDestinationId)
            launchSingleTop = true
        }
        navHostController.navigate(route.route, options)
    }

    fun popUpToHome() {
        navHostController.navigate(HomeRoute){
            popUpTo(navHostController.graph.startDestinationId)
            launchSingleTop = true
        }
    }
}