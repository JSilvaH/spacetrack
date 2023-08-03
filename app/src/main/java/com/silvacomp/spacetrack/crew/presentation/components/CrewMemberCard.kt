package com.silvacomp.spacetrack.crew.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.common.CrewMember.getCrew
import com.silvacomp.spacetrack.crew.data.remote.CrewMember

@Composable
fun CardCrewMember(
    crewMember: CrewMember
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .size(200.dp)
    ) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(crewMember.image)
                    .build(),
                contentDescription = stringResource(id = R.string.description_astronauts),
            )
            Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = returnLogoAgency(crewMember.agency)),
                        contentDescription = "nasa",
                        modifier = Modifier.size(70.dp)
                    )
                    Text(text = crewMember.name, fontSize = 28.sp)

                Row() {
                    Text(
                        text = stringResource(id = R.string.agency),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = crewMember.agency)
                }

                Row() {
                    Text(
                        text = stringResource(id = R.string.missions),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = crewMember.launches.size.toString())
                }


            }
        }
    }
}

private fun returnLogoAgency(agency: String): Int{

   return when(agency){
        "ESA" -> R.drawable.esa
        "NASA" -> R.drawable.nasa
        "JAXA" -> R.drawable.jaxa
        "SpaceX" -> R.drawable.spacex
       "Axiom Space" -> R.drawable.axiomspace
       "Roscosmos" -> R.drawable.roscosmos
       else -> R.drawable.ic_home

    }
}


@Preview
@Composable
fun CardCrewMemberPrev() {
    CardCrewMember(getCrew())
}