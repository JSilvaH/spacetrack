package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class HeightWTrunk(
    @Json(name = "feet")
    val feet: Double,
    @Json(name = "meters")
    val meters: Double
)