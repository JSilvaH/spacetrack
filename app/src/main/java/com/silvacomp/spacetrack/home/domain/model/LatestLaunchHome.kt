package com.silvacomp.spacetrack.home.domain.model

data class LatestLaunchHome(
    val reused: Boolean,
    val image: String,
    val name: String,
    val capsules: Int,
    val cores: Int,
    val id: String,
    val timeUnix: Int,
)