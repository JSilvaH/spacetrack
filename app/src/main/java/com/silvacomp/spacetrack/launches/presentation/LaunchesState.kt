package com.silvacomp.spacetrack.launches.presentation

import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain

data class LaunchesState(
    val isLoading: Boolean = false,
    val listLaunches: List<LaunchDomain> = emptyList(),
    val error: String = ""
)
