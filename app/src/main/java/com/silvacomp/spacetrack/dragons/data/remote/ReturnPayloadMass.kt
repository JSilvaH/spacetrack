package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class ReturnPayloadMass(
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int
)