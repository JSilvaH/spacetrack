package com.silvacomp.spacetrack.ui.components.bottombar

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.silvacomp.spacetrack.R

sealed class BottomNavigationItem(
    var icon: Int,
    var screen: String,
    @StringRes val label: Int
){
    object Home: BottomNavigationItem(R.drawable.ic_home, "Home",R.string.home)
    object Launches: BottomNavigationItem(R.drawable.ic_rocket, "Launches", R.string.launchesBottom)
    object Rockets: BottomNavigationItem(R.drawable.ic_rocket, "Rockets", R.string.rockets)
}
