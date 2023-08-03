package com.silvacomp.spacetrack.launchpads.data.remote


import com.squareup.moshi.Json

data class Images(
    @Json(name = "large")
    val large: List<String>
)