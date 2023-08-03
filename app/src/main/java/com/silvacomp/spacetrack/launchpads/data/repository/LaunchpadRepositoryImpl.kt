package com.silvacomp.spacetrack.launchpads.data.repository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.launchpads.data.mappers.toDomain
import com.silvacomp.spacetrack.launchpads.data.remote.LaunchpadsItem
import com.silvacomp.spacetrack.launchpads.domain.model.LaunchpadDomain
import com.silvacomp.spacetrack.launchpads.domain.repository.LaunchpadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LaunchpadRepositoryImpl @Inject constructor(
    private val api: SpaceXApi
): LaunchpadRepository{
    override suspend fun getLaunchpads(): Flow<Result<List<LaunchpadDomain>>>  = flow{
        emit(Result.Loading())
        val response = api.getLaunchpads().map { it.toDomain() }
        emit(Result.Success(response))
    }.catch {
        emit(Result.Error(it.message ?: "Error"))
    }.flowOn(Dispatchers.IO)

}