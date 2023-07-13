package com.silvacomp.spacetrack.capsules.data.repository

import com.silvacomp.spacetrack.capsules.data.remote.Capsule
import com.silvacomp.spacetrack.capsules.domain.repository.CapsuleRepository
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.common.SpaceXApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CapsuleRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
) : CapsuleRepository {
    override suspend fun getAllCapsules(): Flow<Result<List<Capsule>>> = flow{
        emit(Result.Loading())
        val response = api.getAllCapsules()
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message  ?: "ERROR"))
    }.flowOn(Dispatchers.IO)

    override suspend fun getOneCapsule(idCapsule: String): Flow<Result<Capsule>> = flow{
        emit(Result.Loading())
        val response = api.getOneCapsule(idCapsule)
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "ERROR"))
    }.flowOn(Dispatchers.IO)
}