package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class LandingLegs(
    @Json(name = "material")
    val material: String,
    @Json(name = "number")
    val number: Int
)