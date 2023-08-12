package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CompositeFairing(
    @Json(name = "diameter")
    val diameter: Diameter,
    @Json(name = "height")
    val height: Height
)