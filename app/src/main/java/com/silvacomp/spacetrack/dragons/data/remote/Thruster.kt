package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Thruster(
    @Json(name = "amount")
    val amount: Int,
    @Json(name = "fuel_1")
    val fuel1: String,
    @Json(name = "fuel_2")
    val fuel2: String,
    @Json(name = "isp")
    val isp: Int,
    @Json(name = "pods")
    val pods: Int,
    @Json(name = "thrust")
    val thrust: Thrust,
    @Json(name = "type")
    val type: String
)