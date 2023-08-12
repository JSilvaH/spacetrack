package com.silvacomp.spacetrack.crew.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class CrewMember(
    @Json(name = "agency")
    val agency: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "launches")
    val launches: List<String>,
    @Json(name = "name")
    val name: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "wikipedia")
    val wikipedia: String
)