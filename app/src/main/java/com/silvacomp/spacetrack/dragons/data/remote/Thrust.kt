package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Thrust(
    @Json(name = "kN")
    val kN: Double,
    @Json(name = "lbf")
    val lbf: Int
)