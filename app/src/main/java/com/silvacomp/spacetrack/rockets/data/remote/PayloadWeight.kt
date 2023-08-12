package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class PayloadWeight(
    @Json(name = "id")
    val id: String,
    @Json(name = "kg")
    val kg: Int,
    @Json(name = "lb")
    val lb: Int,
    @Json(name = "name")
    val name: String
)