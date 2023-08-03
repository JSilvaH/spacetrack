package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class LaunchPayloadMass(
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int
)