package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class Thrust(
    @Json(name = "kN")
    val kN: Double,
    @Json(name = "lbf")
    val lbf: Int
)