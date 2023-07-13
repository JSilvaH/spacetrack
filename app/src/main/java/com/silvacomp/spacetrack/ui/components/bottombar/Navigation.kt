package com.silvacomp.spacetrack.ui.components.bottombar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.silvacomp.spacetrack.home.presentation.HomeScreen
import com.silvacomp.spacetrack.launches.presentation.LaunchesScreen
import com.silvacomp.spacetrack.rockets.presentation.RocketsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.screen ){
        composable(BottomNavigationItem.Home.screen){ HomeScreen() }
        composable(BottomNavigationItem.Launches.screen){ LaunchesScreen() }
        composable(BottomNavigationItem.Rockets.screen){ RocketsScreen()}
    }

}