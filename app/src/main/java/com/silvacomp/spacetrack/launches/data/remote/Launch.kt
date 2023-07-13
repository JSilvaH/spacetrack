package com.silvacomp.spacetrack.launches.data.remote

import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain
import com.squareup.moshi.Json

data class Launch(
    @field:Json(name = "auto_update") val auto_update: Boolean,
    @field:Json(name = "capsules") val capsules: List<Any>,
    @field:Json(name = "cores") val cores: List<Core>,
    @field:Json(name = "crew") val crew: List<Any>,
    @field:Json(name = "date_local") val date_local: String,
    @field:Json(name = "date_precision") val date_precision: String,
    @field:Json(name = "date_unix") val date_unix: Int,
    @field:Json(name = "date_utc") val date_utc: String,
    @field:Json(name = "details") val details: String ?= null,
    @field:Json(name = "failures") val failures: List<Failure>,
    @field:Json(name = "fairings") val fairings: Fairings ?= null,
    @field:Json(name = "flight_number") val flight_number: Int,
    @field:Json(name = "id") val id: String,
    @field:Json(name = "launch_library_id") val launch_library_id: Any,
    @field:Json(name = "launchpad") val launchpad: String,
    @field:Json(name = "links") val links: Links,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "net") val net: Boolean,
    @field:Json(name = "payloads") val payloads: List<String>,
    @field:Json(name = "rocket") val rocket: String,
    @field:Json(name = "ships") val ships: List<Any>,
    @field:Json(name = "static_fire_date_unix") val static_fire_date_unix: Int ?= null,
    @field:Json(name = "static_fire_date_utc") val static_fire_date_utc: String ?= null,
    @field:Json(name = "success") val success: Boolean?= null,
    @field:Json(name = "tbd") val tbd: Boolean,
    @field:Json(name = "upcoming") val upcoming: Boolean,
    @field:Json(name = "window") val window: Int ?= null
)


