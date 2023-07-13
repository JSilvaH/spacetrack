package com.silvacomp.spacetrack.rockets.data.remote


import com.squareup.moshi.Json
data class RocketsItem(
    @Json(name = "active")
    val active: Boolean,
    @Json(name = "boosters")
    val boosters: Int,
    @Json(name = "company")
    val company: String,
    @field:Json(name = "cost_per_launch")
    val costPerLaunch: Int,
    @Json(name = "country")
    val country: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "diameter")
    val diameter: Diameter,
    @Json(name = "engines")
    val engines: Engines,
    @field:Json(name = "first_flight")
    val firstFlight: String,
    @Json(name = "first_stage")
    val firstStage: FirstStage,
    @field:Json(name = "flickr_images")
    val flickrImages: List<String>?,
    @Json(name = "height")
    val height: Height,
    @Json(name = "id")
    val id: String,
    @Json(name = "landing_legs")
    val landingLegs: LandingLegs,
    @Json(name = "mass")
    val mass: Mass,
    @Json(name = "name")
    val name: String,
    @Json(name = "payload_weights")
    val payloadWeights: List<PayloadWeight>,
    @Json(name = "second_stage")
    val secondStage: SecondStage,
    @Json(name = "stages")
    val stages: Int,
    @Json(name = "success_rate_pct")
    val successRatePct: Int,
    @Json(name = "type")
    val type: String,
    @Json(name = "wikipedia")
    val wikipedia: String
)