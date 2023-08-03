package com.silvacomp.spacetrack.launchpads.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.launchpads.presentation.components.CardLaunchpad
import com.silvacomp.spacetrack.ui.theme.SpaceTrackTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LaunchpadActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceTrackTheme {
                val viewModel: LaunchpadViewModel = hiltViewModel()
                val launchpad = viewModel.launchpads.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Scaffold(
                       topBar = {
                           TopAppBar(
                               title = {
                                   Text(text = stringResource(id = R.string.launchpads))
                               },
                               navigationIcon = {
                                   IconButton(onClick = { this.finish()}) {
                                       Icon(imageVector = Icons.Filled.ArrowBack,
                                           contentDescription = null)
                                   }
                               }
                           )
                       },
                       content = { paddingValues ->
                           LazyColumn(modifier = Modifier.padding(paddingValues)){
                               items(items = launchpad.value.launchpad, itemContent = { launchpad ->
                                   CardLaunchpad(launchpad)
                               })
                           }

//                           LazyVerticalGrid(columns = GridCells.Adaptive(10.dp), contentPadding = paddingValues, content = {
//                               items(viewModel.launchpads.value.launchpad.size){ index ->
//                                   CardLaunchpad(viewModel.launchpads.value.launchpad[index])
//                               }
//                           })
                       }
                   )
                }
            }
        }
    }


}



