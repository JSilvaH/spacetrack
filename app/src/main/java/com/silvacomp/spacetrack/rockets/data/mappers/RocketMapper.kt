package com.silvacomp.spacetrack.rockets.data.mappers

import android.util.Log
import com.silvacomp.spacetrack.rockets.data.remote.Rockets
import com.silvacomp.spacetrack.rockets.data.remote.RocketsItem
import com.silvacomp.spacetrack.rockets.domain.models.RocketDomain


fun Rockets.listRocketToDomain() : List<RocketDomain> {
    return this.map {
        it.toDomain()
    }
}
fun RocketsItem.toDomain() = RocketDomain(
    idRocket = id,
    imageRocket = flickrImages ?: emptyList(),
    rocketName = name,
    heightRocket = height.meters,
    massRocket = mass.kg,
    active = active,
    cost = costPerLaunch,
    country = country,
    description = description,
    typeEngines = engines.type,
    typeRocket = type,
    firstLaunch = firstFlight

)