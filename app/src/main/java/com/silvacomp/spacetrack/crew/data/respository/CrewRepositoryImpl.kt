package com.silvacomp.spacetrack.crew.data.respository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.crew.data.remote.CrewMember
import com.silvacomp.spacetrack.crew.domain.respository.CrewRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CrewRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
): CrewRepository {
    override suspend fun getAllCrew(): Flow<Result<List<CrewMember>>> = flow{
        emit(Result.Loading())
        val response = api.getAllCrew()
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)

    override suspend fun getOneCrewMember(idCrewMember: String): Flow<Result<CrewMember>> = flow{
        emit(Result.Loading())
        val response = api.getOneCrewMember(idCrewMember)
        emit(Result.Success(response))

    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)
}