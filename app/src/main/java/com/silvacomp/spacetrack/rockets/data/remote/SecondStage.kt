package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json

data class SecondStage(
    @Json(name = "burn_time_sec")
    val burnTimeSec: Int,
    @Json(name = "engines")
    val engines: Int,
    @Json(name = "fuel_amount_tons")
    val fuelAmountTons: Double,
    @Json(name = "payloads")
    val payloads: Payloads,
    @Json(name = "reusable")
    val reusable: Boolean,
    @Json(name = "thrust")
    val thrust: Thrust
)