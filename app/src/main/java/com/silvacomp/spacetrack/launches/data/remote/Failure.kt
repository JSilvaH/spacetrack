package com.silvacomp.spacetrack.launches.data.remote

data class Failure(
    val altitude: Any,
    val reason: String,
    val time: Int
)