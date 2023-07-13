package com.silvacomp.spacetrack.capsules.data.remote


import com.squareup.moshi.Json

data class Capsule(
    @Json(name = "id")
    val id: String,
    @Json(name = "land_landings")
    val landLandings: Int,
    @Json(name = "last_update")
    val lastUpdate: String,
    @Json(name = "launches")
    val launches: List<String>,
    @Json(name = "reuse_count")
    val reuseCount: Int,
    @Json(name = "serial")
    val serial: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "water_landings")
    val waterLandings: Int
)