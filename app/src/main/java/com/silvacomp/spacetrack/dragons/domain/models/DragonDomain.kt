package com.silvacomp.spacetrack.dragons.domain.models

data class DragonDomain(
    val name: String,
    val type: String,
    val active: Boolean,
    val crewCapacity: Int,
    val orbitDuration: Int,
    val dryMass: Int,
    val description: String,
    val firstFlight: String,
    val image: String = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg",
    val diameter: Double,
    val height: Double
)