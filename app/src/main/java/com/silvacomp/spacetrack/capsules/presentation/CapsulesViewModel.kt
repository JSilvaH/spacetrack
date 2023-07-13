package com.silvacomp.spacetrack.capsules.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.capsules.domain.repository.CapsuleRepository
import com.silvacomp.spacetrack.common.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsulesViewModel @Inject constructor(
    private val repository: CapsuleRepository
): ViewModel() {

    private val _capsulesList = MutableStateFlow<CapsulesState>(CapsulesState())
    val capsulesList : StateFlow<CapsulesState> = _capsulesList


    fun getAllCapsules() {
        viewModelScope.launch {
            repository.getAllCapsules().collect{
                when(it){
                    is Result.Success -> {
                        _capsulesList.value = CapsulesState(capsules = it.data?: emptyList())
                    }
                    is Result.Error -> _capsulesList.value = CapsulesState(error = it.message ?: "Error")
                    is Result.Loading -> _capsulesList.value = CapsulesState(loading = true)
                }
            }
        }
    }

}