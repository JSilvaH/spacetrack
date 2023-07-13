package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class ThrustVacuum(
    @Json(name = "kN")
    val kN: Int,
    @Json(name = "lbf")
    val lbf: Int
)