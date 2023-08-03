package com.silvacomp.spacetrack.dragons.data.mappers

import android.util.Log
import com.silvacomp.spacetrack.dragons.data.remote.DragonsItem
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain

fun DragonsItem.toDomain() :DragonDomain {
    return DragonDomain(
        name = name,
        type = type,
        active = active,
        crewCapacity = crewCapacity,
        orbitDuration = orbitDurationYr,
        dryMass = dryMassKg,
        description = description,
        firstFlight = firstFlight,
        image = flickrImages[0],
        diameter = diameter.meters,
        height = heightWTrunk.meters


    )
}