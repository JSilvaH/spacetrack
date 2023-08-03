package com.silvacomp.spacetrack.launches.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.common.unixToDate
import com.silvacomp.spacetrack.launches.data.mappers.toDomain
import com.silvacomp.spacetrack.launches.data.remote.*
import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CardLaunches(launch: LaunchDomain) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .clickable {

            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Black),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "#${launch.flightNumber}",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                )
                Column(

                ) {
                    Text(
                        text = stringResource(id = R.string.launched),
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = launch.dateUnix.unixToDate(),
                        color = Color.White,
                    )

                }
            }
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(start = 4.dp)
            ) {
                Text(
                    text = launch.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.cores),
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = launch.numberCores.toString(),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(id = R.string.crew_members),
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = launch.numberCrewMembers.toString(),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                    }

                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.launch_success),
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        if (launch.launchesSuccessFull){
                            Image(
                                painter = painterResource(id = R.drawable.success),
                                contentDescription = null
                            )
                        }else {
                            Image(
                                painter = painterResource(id = R.drawable.unsuccess),
                                contentDescription = null
                            )
                        }


                    }
                }
            }
        }

    }


}



@Preview
@Composable
fun CardPrev() {
    val launch = Launch(
        fairings = null,
        links = Links(
            "PEPE",
            Flickr(emptyList(), emptyList()),
            Patch("", ""),
            null,
            Reddit(null, null, null, null),
            "",
            "",
            ""
        ),
        static_fire_date_unix = null,
        static_fire_date_utc = null,
        net = false,
        window = null,
        rocket = "5e9d0d95eda69973a809d1ec",
        success = true,
        failures = emptyList(),
        details = null,
        crew = listOf(
            "62dd7196202306255024d13c",
            "62dd71c9202306255024d13d",
            "62dd7210202306255024d13e",
            "62dd7253202306255024d13f"
        ),
        ships = emptyList(),
        capsules = listOf(
            "617c05591bad2c661a6e2909"
        ),
        payloads = listOf(
            "62dd73ed202306255024d145"
        ),
        launchpad = "5e9e4502f509094188566f88",
        flight_number = 187,
        name = "Crew-5",
        date_utc = "2022-10-05T16:00:00.000Z",
        date_unix = 1664985600,
        date_local = "2022-10-05T12:00:00-04:00",
        date_precision = "hour",
        upcoming = false,
        cores = emptyList(),
        auto_update = true,
        tbd = false,
        launch_library_id = "f33d5ece-e825-4cd8-809f-1d4c72a2e0d3",
        id = "62dd70d5202306255024d139"
    )
    SpaceTrackTheme {
        CardLaunches(launch.toDomain())

    }
}