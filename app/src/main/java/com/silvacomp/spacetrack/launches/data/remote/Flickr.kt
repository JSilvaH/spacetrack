package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Flickr(
    val original: List<Any>,
    val small: List<Any>
)