package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class PressurizedCapsule(
    @Json(name = "payload_volume")
    val payloadVolume: PayloadVolume
)