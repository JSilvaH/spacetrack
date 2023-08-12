package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class LaunchPayloadMass(
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int
)