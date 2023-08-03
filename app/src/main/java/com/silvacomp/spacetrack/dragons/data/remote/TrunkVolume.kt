package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class TrunkVolume(
    @Json(name = "cubic_feet")
    val cubicFeet: Int,
    @Json(name = "cubic_meters")
    val cubicMeters: Int
)