package com.silvacomp.spacetrack.dragons.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain

@Composable
fun CardDragon(dragon: DragonDomain) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(400.dp),

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(dragon.image)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                if (dragon.active){
                    Box(modifier = Modifier
                        .padding(10.dp)
                        .clip(CircleShape)
                        .background(Color.Green)
                        .size(20.dp)
                        .align(Alignment.TopEnd))

                }else {
                    Box(modifier = Modifier
                        .padding(10.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                        .size(20.dp)
                        .align(Alignment.TopEnd))
                }
                Text(
                    text = dragon.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomStart)
                        .background(Color.Black.copy(alpha = 0.65f))
                        .padding(start = 10.dp),
                    color = Color.White
                )


            }
            Text(
                text = dragon.description,
                modifier = Modifier.padding(
                    start = 10.dp,
                    end = 10.dp
                ),
                textAlign = TextAlign.Justify,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .background(Color.Black)
                    .padding(start = 10.dp, end = 10.dp, top = 22.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "${dragon.dryMass} kg", color= Color.White)
                    Text(text = stringResource(id = R.string.mass), fontWeight = FontWeight.Bold, color= Color.White)
                }
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "${dragon.height} mts",  color= Color.White)
                    Text(text = stringResource(id = R.string.height), fontWeight = FontWeight.Bold,  color= Color.White)
                }

                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = "${dragon.diameter} mts",  color= Color.White)
                    Text(text = stringResource(id = R.string.diameter), fontWeight = FontWeight.Bold,  color= Color.White)
                }
            }
        }



    }
}