package com.silvacomp.spacetrack.dragons.data.repository

import android.util.Log
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain
import com.silvacomp.spacetrack.dragons.domain.repository.DragonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.dragons.data.mappers.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class DragonRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
): DragonRepository {
    override suspend fun getDragonInfo(): Flow<Result<List<DragonDomain>>> = flow {
        emit(Result.Loading())
        Log.d("PEPE", "Repositorios")
        val response = api.getDragon().map { it.toDomain() }
        Log.d("PEPE", "fotos ${response.size}")
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)
}