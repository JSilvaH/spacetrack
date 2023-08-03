package com.silvacomp.spacetrack.launchpads.presentation

import com.silvacomp.spacetrack.launchpads.domain.model.LaunchpadDomain

data class LaunchpadState(
    val launchpad: List<LaunchpadDomain> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
