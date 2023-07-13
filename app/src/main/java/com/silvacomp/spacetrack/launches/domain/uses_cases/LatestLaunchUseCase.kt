package com.silvacomp.spacetrack.launches.domain.uses_cases

import android.util.Log
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LatestLaunchUseCase @Inject constructor(
    private val repository: LaunchesRepository
){
    operator fun invoke(){

    }
}