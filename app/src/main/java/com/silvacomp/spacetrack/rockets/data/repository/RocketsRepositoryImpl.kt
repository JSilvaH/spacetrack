package com.silvacomp.spacetrack.rockets.data.repository

import android.util.Log
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.rockets.data.mappers.listRocketToDomain
import com.silvacomp.spacetrack.rockets.data.mappers.toDomain
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain
import com.silvacomp.spacetrack.rockets.domain.repository.RocketsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RocketsRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
): RocketsRepository {
    override suspend fun getAllRockets(): Flow<Result<List<RocketDomain>>>  = flow {
        emit(Result.Loading())
        val response = api.getAllRocket().map { it.toDomain() }
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }

    override suspend fun getOneRocket(idRocket: String): Flow<Result<RocketDomain>> = flow{
        emit(Result.Loading())
        val response = api.getOneRocket(idRocket).toDomain()
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "ERROR"))
    }.flowOn(Dispatchers.IO)

}