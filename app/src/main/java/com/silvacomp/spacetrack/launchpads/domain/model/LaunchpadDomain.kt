package com.silvacomp.spacetrack.launchpads.domain.model

data class LaunchpadDomain(
    val name: String?,
    val status: String,
    val locality: String,
    val region: String,
    val landingAttempts: Int,
    val landingSuccess: Int,
    val details: String,
    val numberLaunches: Int,
    val image: String
)