package com.silvacomp.spacetrack.launches.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val repository: LaunchesRepository
) : ViewModel() {

    private val _stateLatestLaunch = MutableStateFlow(LatestLaunchState())
    val stateLatestLaunch: StateFlow<LatestLaunchState> = _stateLatestLaunch

    private val _stateLaunches = MutableStateFlow(LaunchesState())
    val stateLaunches: StateFlow<LaunchesState> = _stateLaunches

    private val _stateNextLaunch = mutableStateOf(NextLaunchState())
    val stateNextLaunch: State<NextLaunchState> = _stateNextLaunch

    init {
        getLastLaunches()
    }


    private fun getLastLaunches() {
        Log.d("PEPE", "Get Last Launches")
        viewModelScope.launch {
            repository.getLastLaunches().collect { launches ->
                when (launches) {
                    is Result.Success -> {
                        Log.d("PEPE", " PEPE ${launches.data?.size}")
                        _stateLaunches.value =
                            LaunchesState(listLaunches = launches.data ?: emptyList())
                    }
                    is Result.Error -> {
                        Log.d("PEPE", "ERROR ${launches.message}")
                        LaunchesState(error = launches.message ?: "ERROR")
                    }
                    is Result.Loading -> {
                        Log.d("PEPE", "Loading")
                        LaunchesState(isLoading = true)
                    }
                }
            }
        }
    }

    fun getLatestLaunch() {
        viewModelScope.launch {
            repository.getLatestLaunch().collect {
                when (it) {
                    is Result.Success -> {
                        _stateLatestLaunch.value = LatestLaunchState(latestLaunch = it.data)
                    }
                    is Result.Error -> {
                        _stateLatestLaunch.value =
                            LatestLaunchState(error = it.message ?: "Unexpected error")
                    }
                    is Result.Loading -> {
                        _stateLatestLaunch.value = LatestLaunchState(isLoading = true)
                    }
                }
            }
        }
    }

    fun getNextLaunch() {
        viewModelScope.launch {
            repository.getNextLaunch().collect {
                when (it) {
                    is Result.Success -> {
                        _stateNextLaunch.value = NextLaunchState(nextLaunch = it.data)
                    }
                    is Result.Error -> {
                        _stateNextLaunch.value =
                            NextLaunchState(error = it.message ?: "Unexpected error")
                    }
                    is Result.Loading -> {
                        _stateNextLaunch.value = NextLaunchState(isLoading = true)
                    }
                }
            }
        }

    }

}
