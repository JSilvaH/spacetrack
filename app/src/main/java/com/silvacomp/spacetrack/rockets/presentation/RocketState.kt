package com.silvacomp.spacetrack.rockets.presentation
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain

data class RocketState(
    val loading: Boolean= false,
    val error:String = "",
    val listRockets: List<RocketDomain> = emptyList()
)
