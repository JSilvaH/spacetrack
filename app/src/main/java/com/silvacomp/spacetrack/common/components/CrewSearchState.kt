package com.silvacomp.spacetrack.common.components

import com.silvacomp.spacetrack.crew.data.remote.CrewMember

data class CrewSearchState(
    val searchText: String = "",
    val members: List<CrewMember> = arrayListOf(),
    val showProgressBar: Boolean = false
){
    companion object{
        val Empty = CrewSearchState()
    }
}