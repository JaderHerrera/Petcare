package com.jasafe.petcare.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppNavItem(
    val labelStringId: String,
    val selectedIconDrawableId: ImageVector,
    val unselectedIconDrawableId: ImageVector,
    val route: Any
) {
    IDENTIFICATION(
        labelStringId = "Identification",
        selectedIconDrawableId = Icons.Filled.Person,
        unselectedIconDrawableId = Icons.Outlined.Person,
        route = IdentificationRoute
    ),

    MONITORING(
        labelStringId = "Monitoring",
        selectedIconDrawableId = Icons.Filled.Favorite,
        unselectedIconDrawableId = Icons.Outlined.FavoriteBorder,
        route = MonitoringRoute
    ),

    ADVICES(
        labelStringId = "Advices",
        selectedIconDrawableId = Icons.Filled.Info,
        unselectedIconDrawableId = Icons.Outlined.Info,
        route = AdvicesRoute
    )
}