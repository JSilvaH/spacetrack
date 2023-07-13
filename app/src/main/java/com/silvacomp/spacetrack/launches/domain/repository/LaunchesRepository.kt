package com.silvacomp.spacetrack.launches.domain.repository

import com.silvacomp.spacetrack.launches.data.remote.Launch
import kotlinx.coroutines.flow.Flow
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.data.remote.LaunchesQuery
import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain

interface LaunchesRepository {
    suspend fun getNextLaunch(): Flow<Result<LaunchDomain>>
    suspend fun getLatestLaunch(): Flow<Result<LaunchDomain>>
    suspend fun getOneLaunch(id:String): Launch
    suspend fun getLastLaunches(): Flow<Result<List<LaunchDomain>>>
}