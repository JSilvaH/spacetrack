package com.silvacomp.spacetrack.capsules.presentation

import com.silvacomp.spacetrack.capsules.data.remote.Capsule
import com.silvacomp.spacetrack.capsules.data.remote.Capsules

data class CapsulesState(
    val loading: Boolean = false,
    val error: String = "",
    val capsules: List<Capsule> = emptyList()
)
