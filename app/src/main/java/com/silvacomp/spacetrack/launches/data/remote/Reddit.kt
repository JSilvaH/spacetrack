package com.silvacomp.spacetrack.launches.data.remote

import androidx.annotation.Keep

@Keep
data class Reddit(
    val campaign: Any ?= null,
    val launch: Any ?= null,
    val media: Any ?= null,
    val recovery: Any ?= null
)