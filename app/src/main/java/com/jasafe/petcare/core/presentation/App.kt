package com.jasafe.petcare.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jasafe.petcare.core.presentation.navigation.AppNavHost
import com.jasafe.petcare.core.presentation.navigation.RegisterRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    appState: AppState = rememberAppState(),
) {
    val navHostController = appState.navHostController

    // Estado del Cajón
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val coroutine = rememberCoroutineScope()

    // States
    val selectedItem = remember { mutableIntStateOf(0) }

    // Cajón Modal (Cajón con Scrim)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Row {
                    Column(
                        modifier = Modifier
                            .width(12.dp + 56.dp + 12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        FilledIconButton(
                            modifier = Modifier.size(56.dp),
                            onClick = {
                                appState.popUpToHome()
                                coroutine.launch { drawerState.close() }
                            },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        }
                        FilledIconButton(
                            modifier = Modifier.size(56.dp),
                            onClick = {coroutine.launch { drawerState.close() }},
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        }
                        FilledIconButton(
                            modifier = Modifier.size(56.dp),
                            onClick = {
                                navHostController.navigate(RegisterRoute)
                                coroutine.launch { drawerState.close() }
                            },
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text("Nombre de la mascota")
                        Spacer(Modifier.height(12.dp))
                        HorizontalDivider()
                        Spacer(Modifier.height(12.dp))
                        appState.drawerNavItems.forEachIndexed { index, item ->
                            val selected = selectedItem.intValue == index

                            NavigationDrawerItem(
                                label = {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (selected) item.selectedIconDrawableId
                                            else item.unselectedIconDrawableId,
                                            contentDescription = null
                                        )
                                        Text(item.labelStringId)
                                    }
                                },
                                selected = selected,
                                onClick = {
                                    appState.navigateToDrawerItem(item)
                                    selectedItem.intValue = index
                                    coroutine.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                }
            }
        },
        drawerState = drawerState,
    ) {
        AppNavHost(navHostController, drawerState)
    }
}