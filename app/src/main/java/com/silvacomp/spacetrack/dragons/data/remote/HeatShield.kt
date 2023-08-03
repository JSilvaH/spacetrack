package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

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