package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Patch(
    val large: String?,
    val small: String?
)