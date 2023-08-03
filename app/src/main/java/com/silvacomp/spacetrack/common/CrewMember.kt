package com.silvacomp.spacetrack.common

import com.silvacomp.spacetrack.crew.data.remote.CrewMember

object CrewMember {
    private val crew = CrewMember(
        name = "Robert Behnken",
        agency = "NASA",
        image = "https://imgur.com/0smMgMH.png",
        wikipedia = "https://en.wikipedia.org/wiki/Robert_L._Behnken",
        launches = listOf("5eb87d46ffd86e000604b388"),
        status = "active",
        id = "5ebf1a6e23a9a60006e03a7a"
    )

    fun getCrew(): CrewMember{
        return  crew
    }
}