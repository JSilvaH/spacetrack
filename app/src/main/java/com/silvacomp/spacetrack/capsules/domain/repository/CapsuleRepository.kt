package com.silvacomp.spacetrack.capsules.domain.repository

import com.silvacomp.spacetrack.capsules.data.remote.Capsule
import com.silvacomp.spacetrack.common.Result
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {
    suspend fun getAllCapsules(): Flow<Result<List<Capsule>>>
    suspend fun getOneCapsule(idCapsule: String): Flow<Result<Capsule>>
}