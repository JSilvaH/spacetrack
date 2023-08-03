package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class Cargo(
    @Json(name = "solar_array")
    val solarArray: Int,
    @Json(name = "unpressurized_cargo")
    val unpressurizedCargo: Boolean
)