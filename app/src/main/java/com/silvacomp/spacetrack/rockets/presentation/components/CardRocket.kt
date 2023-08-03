package com.silvacomp.spacetrack.rockets.presentation.components


import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain
import com.silvacomp.spacetrack.rockets.presentation.RocketScreenDetail

@Composable
fun CardRocket(rocket: RocketDomain) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 15.dp, start = 10.dp, end = 10.dp)
            .clickable {
                val intent = Intent(context, RocketScreenDetail::class.java)
                intent.putExtra("id", rocket.idRocket)
                context.startActivity(intent)
            },

        ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(Color(0xFFe7dfec)),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = rocket.imageRocket[0],
                contentDescription = "Image falcon",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = rocket.rocketName,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Text(
                    text = stringResource(id = R.string.height),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = stringResource(id = R.string.weight),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = stringResource(id = R.string.status),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Text(
                    text = "${rocket.heightRocket} mts",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text = "${rocket.massRocket} kg",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Text(
                    text =  if (rocket.active) stringResource(R.string.active) else stringResource(R.string.inactive) ,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

            }

        }
    }
}


@Preview
@Composable
fun CardRocketPrev() {
    val rocket = RocketDomain(
        idRocket = "rsdfdsfkljds",
        active = false,
        heightRocket = 12,
        imageRocket = emptyList(),
        massRocket = 12,
        rocketName = "test",
        typeRocket = "dsfds",
        typeEngines = "merlin",
        description = "lorem ipsum dolor",
        country = "USA",
        cost = 7885555,
        firstLaunch = ""


    )
    CardRocket(rocket)
}