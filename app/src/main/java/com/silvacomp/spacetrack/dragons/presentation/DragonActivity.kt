package com.silvacomp.spacetrack.dragons.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain
import com.silvacomp.spacetrack.dragons.presentation.components.CardDragon
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DragonActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: DragonViewModel = hiltViewModel()
            val dragons = viewModel.dragons.collectAsState()
            SpaceTrackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                                 TopAppBar(
                                     title = {
                                         Text(text = stringResource(id = R.string.dragon))
                                     },
                                     navigationIcon = {
                                         IconButton(onClick = { this.finish()}) {
                                             Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null )
                                         }
                                     }
                                 )
                        },
                        content = { paddingValues ->
                            LazyColumn(modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()
                           ){
                                items(dragons.value.listDragons, itemContent = { dragon ->
                                    CardDragon(dragon)
                                })
                            }
                        }
                    )
                }
            }
        }
    }
}

