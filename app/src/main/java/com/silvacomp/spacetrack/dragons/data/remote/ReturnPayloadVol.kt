package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class ReturnPayloadVol(
    @Json(name = "cubic_feet")
    val cubicFeet: Int,
    @Json(name = "cubic_meters")
    val cubicMeters: Int
)