package com.silvacomp.spacetrack.dragons.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.dragons.domain.repository.DragonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DragonViewModel @Inject constructor(
    private val repository: DragonRepository
): ViewModel() {
    private val _dragons = MutableStateFlow(DragonState())
    val dragons  =_dragons.asStateFlow()

    init {
        getDragonInfo()
    }

    private fun getDragonInfo(){
        viewModelScope.launch {
            repository.getDragonInfo().collect{
                when(it){
                    is Result.Success -> _dragons.value = DragonState(listDragons = it.data!!)
                    is Result.Error -> _dragons.value = DragonState(error = it.message ?: "error")
                    is Result.Loading -> _dragons.value = DragonState(isLoading = true)
                }
            }
        }
    }
}