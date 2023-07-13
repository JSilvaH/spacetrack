package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class CompositeFairing(
    @Json(name = "diameter")
    val diameter: Diameter,
    @Json(name = "height")
    val height: Height
)