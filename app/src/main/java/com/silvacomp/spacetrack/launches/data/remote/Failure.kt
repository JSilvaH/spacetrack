package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Failure(
    val altitude: Any,
    val reason: String,
    val time: Int
)