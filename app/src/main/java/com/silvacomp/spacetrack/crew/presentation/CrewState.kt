package com.silvacomp.spacetrack.crew.presentation

import com.silvacomp.spacetrack.crew.data.remote.CrewMember

data class CrewState(
    val crewMembers: List<CrewMember> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
