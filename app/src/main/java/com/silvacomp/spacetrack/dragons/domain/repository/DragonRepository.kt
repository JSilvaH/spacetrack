package com.silvacomp.spacetrack.dragons.domain.repository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain
import kotlinx.coroutines.flow.Flow

interface DragonRepository {
    suspend fun getDragonInfo() : Flow<Result<List<DragonDomain>>>
}