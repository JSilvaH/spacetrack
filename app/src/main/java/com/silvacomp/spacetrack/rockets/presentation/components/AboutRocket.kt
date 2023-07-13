package com.silvacomp.spacetrack.rockets.presentation.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.silvacomp.spacetrack.common.components.Label
import com.silvacomp.spacetrack.rockets.data.remote.RocketsItem
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme

@Composable
fun AboutRocket(
//    rocket: RocketsItem
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        Surface(
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 3.dp
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 20.dp)
            ) {
                Column(
                    Modifier.weight(1f)
                ) {
                    Label(text = "Height")
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "100m")
                }
                
                Column(Modifier.weight(1f)) {
                    Label(text = "Weight")
                    Spacer(Modifier.height(12.dp))
                    Text(text = "1400kg")
                }
            }

        }

        RocketSpecifications()

    }
}

@Composable
fun RocketSpecifications(
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            "DETAILS",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(24.dp))
        Row(){
            Label(text =  "First launch", )
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
fun AboutRocketPrev() {
    SpaceTrackTheme {
        AboutRocket()
    }
}