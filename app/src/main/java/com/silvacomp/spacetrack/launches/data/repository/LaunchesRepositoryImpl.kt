package com.silvacomp.spacetrack.launches.data.repository

import android.util.Log
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.data.mappers.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class LaunchesRepositoryImpl @Inject constructor(
   private val api:SpaceXApi
): LaunchesRepository {
    override suspend fun getNextLaunch() = flow{
        emit(Result.Loading())
        val response = api.getNextLaunch().toDomain()
        emit(Result.Success(response))

    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)

    override suspend fun getLatestLaunch() = flow {
        emit(Result.Loading())
        val response = api.getLatestLaunch().toDomain()
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "ERROR"))
    }.flowOn(Dispatchers.IO)

    override suspend fun getOneLaunch(id: String): Launch {
        return api.getOneLaunch(id)
    }

    override suspend fun getLastLaunches() = flow{
        emit(Result.Loading())
        Log.d("PEPE", "Loading last launches repository")
        val response = api.getLaunches().map { it.toDomain() }
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)

}