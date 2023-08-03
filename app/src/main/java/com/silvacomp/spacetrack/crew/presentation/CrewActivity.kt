package com.silvacomp.spacetrack.crew.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.crew.presentation.components.ContentCrewMembers
import com.silvacomp.spacetrack.rockets.presentation.RocketScreenDetailContent
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CrewActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel: CrewViewModel = hiltViewModel()
            val listCrewMembers = viewModel.stateCrewMembers.collectAsState()
            SpaceTrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(stringResource(id = R.string.crew_members))
                                },
                                navigationIcon = {
                                    IconButton(onClick = { this.finish()}) {
                                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                                    }
                                }
                            )
                        },
                        content = { padding ->
                           ContentCrewMembers(padding, listCrewMembers.value.crewMembers)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: CrewViewModel) {
    val crew = viewModel.stateCrewMembers.collectAsState()
    Text(
        text = "Hello $name!"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SpaceTrackTheme {

    }
}