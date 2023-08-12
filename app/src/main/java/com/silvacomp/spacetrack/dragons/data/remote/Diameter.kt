package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Diameter(
    @Json(name = "feet")
    val feet: Int,
    @Json(name = "meters")
    val meters: Double
)