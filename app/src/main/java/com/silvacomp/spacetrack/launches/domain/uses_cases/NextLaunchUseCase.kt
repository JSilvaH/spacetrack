package com.silvacomp.spacetrack.launches.domain.uses_cases

import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NextLaunchUseCase @Inject constructor(
    private val repository: LaunchesRepository
) {
    suspend operator fun invoke() {
       val response =  repository.getNextLaunch()

    }
}