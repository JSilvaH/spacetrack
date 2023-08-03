package com.silvacomp.spacetrack.launchpads.domain.repository

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launchpads.data.remote.LaunchpadsItem
import com.silvacomp.spacetrack.launchpads.domain.model.LaunchpadDomain
import kotlinx.coroutines.flow.Flow

interface LaunchpadRepository {

    suspend fun getLaunchpads(): Flow<Result<List<LaunchpadDomain>>>
}