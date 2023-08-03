package com.silvacomp.spacetrack.dragons.data.remote


import com.squareup.moshi.Json

data class Trunk(
    @Json(name = "cargo")
    val cargo: Cargo,
    @Json(name = "trunk_volume")
    val trunkVolume: TrunkVolume
)