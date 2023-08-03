package com.silvacomp.spacetrack.crew.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.crew.domain.respository.CrewRepository
import com.silvacomp.spacetrack.launches.presentation.LatestLaunchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CrewViewModel @Inject constructor(
    private val repository: CrewRepository
):ViewModel() {
    private val _stateCrewMembers = MutableStateFlow(CrewState())
    val stateCrewMembers: StateFlow<CrewState> = _stateCrewMembers
    init {
        getAllMembersCrew()
    }

    private fun getAllMembersCrew(){
        viewModelScope.launch {
            repository.getAllCrew().collect(){
                when(it){
                    is Result.Success -> {
                        _stateCrewMembers.value = CrewState(crewMembers = it.data!!)
                        Log.d("PEPE", "Desde viewmodel ${it.data.size}")
                    }
                    is Result.Error -> _stateCrewMembers.value = CrewState(error = it.message ?: "Error")
                    is Result.Loading -> _stateCrewMembers.value = CrewState(isLoading = true)
                }
            }
        }
    }
}