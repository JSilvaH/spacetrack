package com.silvacomp.spacetrack.rockets.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.rockets.presentation.components.CardRocket

@Composable
fun RocketsScreen(
    viewModel: RocketsViewModel = hiltViewModel()
) {
    val list = viewModel.listAllRockets.collectAsState()

    LazyColumn() {
        items(list.value.listRockets) { rocket ->
            CardRocket(rocket)
        }
    }

}