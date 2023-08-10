package com.silvacomp.spacetrack.crew.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.crew.data.remote.CrewMember
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

    private val _stateCrewMembersCopy = MutableStateFlow(CrewState())
    val stateCrewMembersCopy: StateFlow<CrewState> = _stateCrewMembersCopy

    private val _search = MutableStateFlow("")
    val search: StateFlow<String> = _search

    private var matchedUsers: MutableStateFlow<List<CrewMember>> = MutableStateFlow(arrayListOf())
    init {
        getAllMembersCrew()
    }

    private fun getAllMembersCrew(){
        viewModelScope.launch {
            repository.getAllCrew().collect(){
                when(it){
                    is Result.Success -> {
                        _stateCrewMembers.value = CrewState(crewMembers = it.data!!)
                        _stateCrewMembersCopy.value = CrewState(crewMembers = it.data!!)
                    }
                    is Result.Error -> _stateCrewMembers.value = CrewState(error = it.message ?: "Error")
                    is Result.Loading -> _stateCrewMembers.value = CrewState(isLoading = true)
                }
            }
        }
    }

    fun onSearchTextChanged(text: String){
        _search.value = text
        if (text.isEmpty()){
            _stateCrewMembersCopy.value = CrewState(crewMembers = _stateCrewMembers.value.crewMembers)
            return
        }

        val crewMembersSearch = _stateCrewMembersCopy.value.crewMembers.filter { crewMember ->
            crewMember.name.contains(text, true) || crewMember.agency.contains(text, true)
        }

        _stateCrewMembersCopy.value = CrewState(crewMembers = crewMembersSearch)




    }

    fun clearSearch(){
        _search.value = ""
        matchedUsers.value = arrayListOf()

    }
}