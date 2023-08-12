package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class PressurizedCapsule(
    @Json(name = "payload_volume")
    val payloadVolume: PayloadVolume
)