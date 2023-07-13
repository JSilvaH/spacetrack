package com.silvacomp.spacetrack.rockets.presentation.components

import android.speech.tts.TextToSpeech.Engine
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme

@Composable
fun Engine() {
    Text(text = "ENGINE")
}


@Preview
@Composable
fun EnginePrev() {
    SpaceTrackTheme {
        Engine()
    }
}