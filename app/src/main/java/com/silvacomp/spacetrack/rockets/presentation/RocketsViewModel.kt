package com.silvacomp.spacetrack.rockets.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silvacomp.spacetrack.common.Result
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain
import com.silvacomp.spacetrack.rockets.domain.repository.RocketsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RocketsViewModel @Inject constructor(
    val repository: RocketsRepository
): ViewModel(){

    private var _listAllRockets = MutableStateFlow(RocketState())
    val listAllRockets =_listAllRockets.asStateFlow()

    var rockets by mutableStateOf(RocketState())
     private set



    private val _rocket = MutableStateFlow(RocketDomain(
        idRocket = "rsdfdsfkljds",
        active = false,
        heightRocket = 12,
        imageRocket = listOf("https://imgur.com/azYafd8.jpg"),
        massRocket = 12,
        rocketName = "test",
        typeRocket = "dsfds",
        typeEngines = "merlin",
        description = "lorem ipsum dolor",
        country = "USA",
        cost = 7885555,
        firstLaunch =""

    ))
    val rocket: StateFlow<RocketDomain> = _rocket

    init {
        getRockets()
    }

    fun getOneRocket(id:String){
        viewModelScope.launch {
            repository.getOneRocket(id).collect{
                when (it){
                    is Result.Error -> Log.e("PEPE", it.message?: "An error has ocurred")
                    is Result.Loading -> Log.d("PEPE", "Loading...")
                    is Result.Success -> {
                        _rocket.value = it.data!!
                        Log.d("PEPE", "Success")
                    }
                }
            }
        }
    }

    private fun getRockets(){
        viewModelScope.launch {
            repository.getAllRockets().collect{
                when(it){
                    is Result.Success -> {
                        _listAllRockets.value = RocketState(listRockets = it.data ?: emptyList())
                        rockets = RocketState(listRockets = it.data ?: emptyList())
                    }
                    is Result.Error -> {
                        _listAllRockets.value = RocketState(error = it.message ?: "error")
                    }
                    is Result.Loading -> {
                        _listAllRockets.value = RocketState(loading = true)
                    }
                }
            }
        }
    }
}