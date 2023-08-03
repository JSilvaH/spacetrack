package com.silvacomp.spacetrack.rockets.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain

@AndroidEntryPoint
class RocketScreenDetail : ComponentActivity() {
    private lateinit var idRocket: String
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idRocket = intent.extras!!.getString("id", "s12321321")
        setContent {
            val viewModel: RocketsViewModel = hiltViewModel()
            val rocket = viewModel.rocket.collectAsState()
            viewModel.getOneRocket(idRocket)
            SpaceTrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(rocket.value.rocketName)
                                },
                                navigationIcon = {
                                    IconButton(onClick = { this.finish()}) {
                                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                                    }
                                }
                            )
                        },
                        content = { padding ->
                            RocketScreenDetailContent(Modifier.padding(padding),rocket.value)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RocketScreenDetailContent(modifier: Modifier,rocket: RocketDomain) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,

    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(rocket.imageRocket[0])
                    .build(),
                contentDescription = null )

        }
        Text(
            text = rocket.description,
            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            textAlign = TextAlign.Justify
            )

        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

                ){
            Card(
                shape = RoundedCornerShape(10.dp),

            ) {
                Column(
                    modifier = Modifier.padding(20.dp, 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Pais", fontWeight = FontWeight.Bold)
                    Text(text = rocket.country)
                }
            }
            Card() {
                Column(
                    modifier = Modifier.padding(20.dp, 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Status", fontWeight = FontWeight.Bold)
                    if (rocket.active){
                        Box(modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.Red))

                    }else {
                        Box(modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.Green))
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Card(
                shape = RoundedCornerShape(10.dp),

                ) {
                Column(
                    modifier = Modifier.padding(20.dp, 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Costo por lanzmiento", fontWeight = FontWeight.Bold)
                    Text(text = rocket.imageRocket.size.toString())
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
        Card() {
            Column(
                modifier = Modifier.padding(20.dp, 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Primer lanzamiento", fontWeight = FontWeight.Bold)
                Text(text = rocket.firstLaunch ?: "no launch date")

            }

        }

        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    val rocket = RocketDomain(
        "qweqwe",
        listOf("pepep", "sdf"),
        "FALCON",
        23,
        34,
        true,
        "merlin",
        "rocket",
        788888,
        "USA",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        ""
    )
    SpaceTrackTheme {
        RocketScreenDetailContent(Modifier,rocket)
    }
}