package com.silvacomp.spacetrack.launchpads.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.silvacomp.spacetrack.launchpads.domain.model.LaunchpadDomain

@Composable
fun CardLaunchpad(launchpad: LaunchpadDomain) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(8.dp)
            .clickable { },
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.TopStart
            ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(launchpad.image).build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = launchpad.name ?: "No name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(0.7f)),
                    color = Color.White,
                    textAlign = TextAlign.Center

                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = launchpad.region,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(0.7f)),
                    color = Color.White,
                    textAlign = TextAlign.Center

                )
            }
            

        }

    }

}