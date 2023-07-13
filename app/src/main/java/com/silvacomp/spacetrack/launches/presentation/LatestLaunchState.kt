package com.silvacomp.spacetrack.launches.presentation
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.data.remote.LaunchesQuery
import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain

data class LatestLaunchState(
    val isLoading: Boolean = false,
    val latestLaunch: LaunchDomain?= null,
    val error: String = ""
)
