package com.silvacomp.spacetrack.ui.components.bottombar

import com.silvacomp.spacetrack.R

sealed class BottomNavigationItem(
    var icon: Int,
    var screen: String,
    val label: String
){
    object Home: BottomNavigationItem(R.drawable.ic_home, "Home", "HOME")
    object Launches: BottomNavigationItem(R.drawable.ic_rocket, "Launches", "Launches")
    object Rockets: BottomNavigationItem(R.drawable.ic_rocket, "Rockets", "Rockets")
}
