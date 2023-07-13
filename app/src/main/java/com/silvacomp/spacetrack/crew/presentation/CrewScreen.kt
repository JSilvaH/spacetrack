package com.silvacomp.spacetrack.crew.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme

@Composable
fun CrewScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row() {
            Text(text = "Robert Behnken")
            Text(text = "Active")
        }
        Row {
            Text(text = "NASA")

        }
    }
    
}


@Preview(
    showBackground = true,
    name = "Crew Screen"
)
@Composable
fun CrewScreenPrev() {
    SpaceTrackTheme {
        CrewScreen()
    }
}