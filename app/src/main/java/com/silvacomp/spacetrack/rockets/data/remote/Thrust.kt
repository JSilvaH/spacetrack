package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Thrust(
    @Json(name = "kN")
    val kN: Int,
    @Json(name = "lbf")
    val lbf: Int
)