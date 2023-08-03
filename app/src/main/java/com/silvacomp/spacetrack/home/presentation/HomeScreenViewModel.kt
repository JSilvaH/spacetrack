package com.silvacomp.spacetrack.home.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import com.silvacomp.spacetrack.launches.presentation.LatestLaunchState
import com.silvacomp.spacetrack.launches.presentation.LaunchesState
import com.silvacomp.spacetrack.launches.presentation.NextLaunchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: LaunchesRepository
): ViewModel() {
    private val _stateLatestLaunch = MutableStateFlow(LatestLaunchState())
    val stateLatestLaunch: StateFlow<LatestLaunchState> = _stateLatestLaunch

    private val _nextLaunchState = MutableStateFlow(NextLaunchState())
    val stateNextLaunch: StateFlow<NextLaunchState> = _nextLaunchState

    init {
        viewModelScope.launch {
          repository.getLatestLaunch().collect(){
              when(it){
                  is Result.Success -> {
                      _stateLatestLaunch.value = LatestLaunchState(latestLaunch = it.data)
                  }
                  is Result.Error -> _stateLatestLaunch.value = LatestLaunchState(error = it.message ?: "error")
                  is Result.Loading -> _stateLatestLaunch.value = LatestLaunchState(isLoading = true)
              }
          }
            repository.getNextLaunch().collect(){
                when(it){
                    is Result.Success -> {
                        _nextLaunchState.value = NextLaunchState(nextLaunch = it.data)
                    }
                    is Result.Error -> _nextLaunchState.value = NextLaunchState(error = it.message ?: "Error")
                    is Result.Loading -> _nextLaunchState.value = NextLaunchState(isLoading = true)
                }
            }
        }
    }
}