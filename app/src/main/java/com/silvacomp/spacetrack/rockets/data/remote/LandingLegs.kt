package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class LandingLegs(
    @Json(name = "material")
    val material: String,
    @Json(name = "number")
    val number: Int
)