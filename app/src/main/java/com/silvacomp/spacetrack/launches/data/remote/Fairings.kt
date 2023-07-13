package com.silvacomp.spacetrack.launches.data.remote

data class Fairings(
    val recovered: Boolean?= null,
    val recovery_attempt: Boolean?= null,
    val reused: Boolean?= null,
    val ships: List<Any>?= null
)