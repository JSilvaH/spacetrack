package com.silvacomp.spacetrack.rockets.domain.repository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain
import kotlinx.coroutines.flow.Flow

interface RocketsRepository {
    suspend fun getAllRockets(): Flow<Result<List<RocketDomain>>>
    suspend fun getOneRocket(idRocket: String): Flow<Result<RocketDomain>>
}