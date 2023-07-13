package com.silvacomp.spacetrack.launches.data.remote

data class Core(
    val core: String?=null,
    val flight: Int?=null,
    val gridfins: Boolean ?=null,
    val landing_attempt: Boolean?= null,
    val landing_success: Any?=null,
    val landing_type: Any?=null,
    val landpad: Any?=null,
    val legs: Boolean?=null,
    val reused: Boolean?=null
)