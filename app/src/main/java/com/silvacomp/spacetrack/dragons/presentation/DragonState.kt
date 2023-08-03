package com.silvacomp.spacetrack.dragons.presentation

import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain

data class DragonState(
    val listDragons: List<DragonDomain> = emptyList(),
    val error:String = "",
    val isLoading: Boolean = false
)
