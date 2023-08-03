package com.silvacomp.spacetrack.home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.common.unixToDate


@Composable
fun InfoLaunch(
    title: String,
    flightNumber: Int,
    image: String,
    crewMembers: Int,
    date: Int

) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 5.dp)
            .clickable { expanded = !expanded },
        backgroundColor = Color.Black
    )
    {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Black)
                    .fillMaxWidth(),
                color = Color.White
            )
            AnimatedVisibility(visible = expanded) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Row {
                            Text(
                                text = stringResource(id = R.string.flight_number),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = flightNumber.toString(),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        Row {
                            Text(
                                text = stringResource(id = R.string.crew_members),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = stringResource(id = R.string.members, crewMembers),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp)
                            )
                        }

                        Row {
                            Text(
                                text = stringResource(id = R.string.date_launch),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp),
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = date.unixToDate(),
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        
                    }



                    AsyncImage(
                        modifier = Modifier.padding(end = 10.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .build(),

                        contentDescription = stringResource(
                            id = R.string.description
                        )
                    )
                }

            }
        }
    }
}
