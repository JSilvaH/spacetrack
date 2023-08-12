package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Links(
    val article: String ?= null,
    val flickr: Flickr,
    val patch: Patch,
    val presskit: Any ?= null,
    val reddit: Reddit,
    val webcast: String,
    val wikipedia: String,
    val youtube_id: String
)