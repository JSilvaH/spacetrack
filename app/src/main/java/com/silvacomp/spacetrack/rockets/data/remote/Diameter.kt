package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class Diameter(
    @Json(name = "feet")
    val feet: Double,
    @Json(name = "meters")
    val meters: Double
)