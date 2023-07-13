package com.silvacomp.spacetrack.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silvacomp.spacetrack.ui.components.bottombar.BottomNavigationItem

@Composable
fun BottomBarSpaceTrack(navController: NavController) {
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Launches,
        BottomNavigationItem.Rockets
    )
    var selectedItem by remember { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {Icon(painterResource(item.icon), contentDescription = null)},
                label = { Text(item.label)},
                selected = currentRoute == item.screen,
                onClick = {
                    navController.navigate(item.screen){
                        navController.graph.startDestinationRoute?.let { screenRoute  ->
                            popUpTo(screenRoute){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}