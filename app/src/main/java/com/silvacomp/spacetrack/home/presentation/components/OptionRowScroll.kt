package com.silvacomp.spacetrack.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OptionsRowScroll(
    title: String
) {
    androidx.compose.material.Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 50.dp)
            .width(150.dp)
            .height(100.dp),
        backgroundColor = Color.Black
    ){
        Column() {
            Text( text = title, color = Color.White)
        }
    }
}