package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class Diameter(
    @Json(name = "feet")
    val feet: Int,
    @Json(name = "meters")
    val meters: Double
)