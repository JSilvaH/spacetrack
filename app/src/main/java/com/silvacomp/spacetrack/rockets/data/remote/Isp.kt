package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class Isp(
    @Json(name = "sea_level")
    val seaLevel: Int,
    @Json(name = "vacuum")
    val vacuum: Int
)