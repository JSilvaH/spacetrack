package com.silvacomp.spacetrack.launchpads.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.launchpads.domain.repository.LaunchpadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchpadViewModel @Inject constructor(
    private val repository: LaunchpadRepository
) : ViewModel() {

    private val _launchpads = MutableStateFlow(LaunchpadState())
    val launchpads: StateFlow<LaunchpadState> =_launchpads
    init {
        getLaunchpads()
    }

    private fun getLaunchpads(){
        Log.d("PEPE", "Entro a getLaunchPads")
        viewModelScope.launch {
            repository.getLaunchpads().collect{
                when(it){
                    is Result.Success -> {
                        Log.d("PEPE", "aqui toy")
                        _launchpads.value = LaunchpadState(launchpad = it.data!!)
                        Log.d("PEPE", it.data.size.toString())
                    }
                    is Result.Error -> {
                        Log.d("PEPE", it.message?: "PEPERROR")
                        _launchpads.value = LaunchpadState(error = it.message ?: "Error")
                    }
                    is Result.Loading -> _launchpads.value = LaunchpadState(isLoading = true)
                }
            }
        }
    }
}