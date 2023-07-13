package com.silvacomp.spacetrack.launches.presentation

import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain

data class NextLaunchState(
    val nextLaunch: LaunchDomain?= null,
    val isLoading: Boolean = false,
    val error: String = ""
)
