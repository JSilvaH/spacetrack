package com.silvacomp.spacetrack.crew.presentation

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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.silvacomp.spacetrack.R
import com.silvacomp.spacetrack.common.components.SearchBarUi
import com.silvacomp.spacetrack.crew.presentation.components.CardCrewMember
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
            val search = viewModel.search.collectAsState()
            val listCrew = viewModel.stateCrewMembersCopy.collectAsState()
            SpaceTrackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
//                            TopAppBar(
//                                title = {
//                                    Text(stringResource(id = R.string.crew_members))
//                                },
//                                navigationIcon = {
//                                    IconButton(onClick = { this.finish()}) {
//                                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
//                                    }
//                                }
//                            )
                        },
                        content = { padding ->
                            SearchBarUi(
                                searchText = search.value,
                                matchesFound = listCrew.value.crewMembers.isNotEmpty(),
                                placeholderText = stringResource(id = R.string.search),
                                onSearchTextChanged = { viewModel.onSearchTextChanged(it) },
                                onClearClick = { viewModel.clearSearch() },
                                onNavigateBack = { this.finish() }
                            ) {
                                LazyColumn(
                                    modifier = Modifier
                                        .padding(padding)
                                        .fillMaxSize()
                                ) {
                                    items(listCrew.value.crewMembers, itemContent = { crewMember ->
                                        CardCrewMember(crewMember)
                                    })
                                }
                            }

                        }
                    )
                }
            }
        }
    }
}

