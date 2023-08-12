package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Trunk(
    @Json(name = "cargo")
    val cargo: Cargo,
    @Json(name = "trunk_volume")
    val trunkVolume: TrunkVolume
)