package com.silvacomp.spacetrack.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.common.FakeLaunch
import com.silvacomp.spacetrack.launches.domain.uses_cases.LatestLaunchUseCase
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme


@Composable
fun LatestLaunch() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            ) {
            Image(
                painter = painterResource(id = R.drawable.image_placeholder),
                contentDescription = "",
                modifier = Modifier
                    .width(135.dp)
                    .height(150.dp)
                    .zIndex(100f)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Red)

            )
            Column(
                modifier = Modifier
                    .background(Color.Blue)
                    .width(250.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(100.dp)
                    .padding(end = 50.dp)
                    .zIndex(50f)
                    .align(Alignment.CenterEnd)


            ) {
                Text(text = "NOMBRE LANZAMIENTO")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LatestLaunchPrev() {
    SpaceTrackTheme {
        LatestLaunch()
    }
}