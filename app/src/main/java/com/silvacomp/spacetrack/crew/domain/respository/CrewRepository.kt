package com.silvacomp.spacetrack.crew.domain.respository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.crew.data.remote.CrewMember
import kotlinx.coroutines.flow.Flow

interface CrewRepository {
    suspend fun getAllCrew(): Flow<Result<List<CrewMember>>>
    suspend fun getOneCrewMember(idCrewMember: String): Flow<Result<CrewMember>>
}