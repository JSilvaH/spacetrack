package com.silvacomp.spacetrack.crew.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.silvacomp.spacetrack.crew.data.remote.CrewMember

@Composable
fun ContentCrewMembers(padding: PaddingValues, listMembers: List<CrewMember>) {
    LazyColumn(modifier = Modifier
        .padding(padding)
        .fillMaxSize()){
        items(listMembers, itemContent = {crewMember ->
            CardCrewMember(crewMember)
        })
    }
}