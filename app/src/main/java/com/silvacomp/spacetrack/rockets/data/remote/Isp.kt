package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Isp(
    @Json(name = "sea_level")
    val seaLevel: Int,
    @Json(name = "vacuum")
    val vacuum: Int
)