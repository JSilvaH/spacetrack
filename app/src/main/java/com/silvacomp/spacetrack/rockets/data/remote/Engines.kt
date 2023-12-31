package com.silvacomp.spacetrack.rockets.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Engines(
    @Json(name = "engine_loss_max")
    val engineLossMax: Int,
    @Json(name = "isp")
    val isp: Isp,
    @Json(name = "layout")
    val layout: String,
    @Json(name = "number")
    val number: Int,
    @Json(name = "propellant_1")
    val propellant1: String,
    @Json(name = "propellant_2")
    val propellant2: String,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel,
    @Json(name = "thrust_to_weight")
    val thrustToWeight: Double,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuum,
    @Json(name = "type")
    val type: String,
    @Json(name = "version")
    val version: String
)