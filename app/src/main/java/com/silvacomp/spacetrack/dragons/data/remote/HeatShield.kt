package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class HeatShield(
    @Json(name = "dev_partner")
    val devPartner: String,
    @Json(name = "material")
    val material: String,
    @Json(name = "size_meters")
    val sizeMeters: Double,
    @Json(name = "temp_degrees")
    val tempDegrees: Int
)