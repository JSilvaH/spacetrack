package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class Mass(
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int
)