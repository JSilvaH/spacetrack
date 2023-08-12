package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Mass(
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int
)