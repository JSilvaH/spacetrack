package com.silvacomp.spacetrack.launches.domain.model

data class LaunchDomain(
    val flightNumber: Int,
    val dateUnix: Int,
    val name: String,
    val numberCores: Int,
    val numberCrewMembers: Int,
    val launchesSuccessFull: Boolean
)
