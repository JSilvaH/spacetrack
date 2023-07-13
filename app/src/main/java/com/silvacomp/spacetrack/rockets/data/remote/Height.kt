package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class Height(
    @Json(name = "feet")
    val feet: Double,
    @Json(name = "meters")
    val meters: Double
)