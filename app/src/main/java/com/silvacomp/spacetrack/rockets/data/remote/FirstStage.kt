package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class FirstStage(
    @Json(name = "burn_time_sec")
    val burnTimeSec: Int,
    @Json(name = "engines")
    val engines: Int,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double,
    @Json(name = "reusable")
    val reusable: Boolean,
    @Json(name = "thrust_sea_level")
    val thrustSeaLevel: ThrustSeaLevel,
    @Json(name = "thrust_vacuum")
    val thrustVacuum: ThrustVacuum
)