package com.silvacomp.spacetrack.launchpads.data.remote


import com.squareup.moshi.Json

data class LaunchpadsItem(
    @Json(name = "details")
    val details: String,
    @field:Json(name = "full_name")
    val fullName: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "images")
    val images: Images,
    @Json(name = "landing_attempts")
    val landingAttempts: Int,
    @Json(name = "landing_successes")
    val landingSuccesses: Int,
    @Json(name = "latitude")
    val latitude: Double,
    @Json(name = "launches")
    val launches: List<String>,
    @Json(name = "locality")
    val locality: String,
    @Json(name = "longitude")
    val longitude: Double,
    @Json(name = "name")
    val name: String,
    @Json(name = "region")
    val region: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "wikipedia")
    val wikipedia: String
)