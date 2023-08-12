package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class ThrustSeaLevel(
    @Json(name = "kN")
    val kN: Int,
    @Json(name = "lbf")
    val lbf: Int
)