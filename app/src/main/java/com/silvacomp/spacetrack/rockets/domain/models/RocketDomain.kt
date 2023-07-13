package com.silvacomp.spacetrack.rockets.domain.models

data class RocketDomain(
    val idRocket: String,
    val imageRocket:List<String>,
    val rocketName: String,
    val heightRocket: Number,
    val massRocket: Int,
    val active: Boolean,
    val typeEngines: String,
    val typeRocket: String,
    val cost: Int,
    val country: String,
    val description: String,
    val firstLaunch: String?
)
