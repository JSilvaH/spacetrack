package com.silvacomp.spacetrack.launchpads.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class Images(
    @Json(name = "large")
    val large: List<String>
)