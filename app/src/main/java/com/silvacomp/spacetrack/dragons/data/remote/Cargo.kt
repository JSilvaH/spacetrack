package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Cargo(
    @Json(name = "solar_array")
    val solarArray: Int,
    @Json(name = "unpressurized_cargo")
    val unpressurizedCargo: Boolean
)