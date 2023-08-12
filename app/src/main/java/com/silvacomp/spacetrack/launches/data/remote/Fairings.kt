package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Fairings(
    val recovered: Boolean?= null,
    val recovery_attempt: Boolean?= null,
    val reused: Boolean?= null,
    val ships: List<Any>?= null
)