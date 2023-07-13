package com.silvacomp.spacetrack.launches.presentation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.launches.presentation.components.CardLaunches

@Composable
fun LaunchesScreen(
    viewModel: LaunchesViewModel = hiltViewModel()
) {
    val launches = viewModel.stateLaunches.collectAsState()


    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = launches.value.listLaunches, itemContent = { item ->
            CardLaunches(item)
        })
    }


}


