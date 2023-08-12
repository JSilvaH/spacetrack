package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class HeightWTrunk(
    @Json(name = "feet")
    val feet: Double,
    @Json(name = "meters")
    val meters: Double
)