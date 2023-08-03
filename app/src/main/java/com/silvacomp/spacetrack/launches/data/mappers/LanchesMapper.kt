package com.silvacomp.spacetrack.launches.data.mappers

import com.silvacomp.spacetrack.home.domain.model.LatestLaunchHome
import com.silvacomp.spacetrack.launches.data.remote.Fairings
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.domain.model.LaunchDomain

fun Launch.toDomain() = LaunchDomain(
    flightNumber = flight_number,
    dateUnix = date_unix,
    name = name,
    numberCores = cores.size,
    numberCrewMembers = crew.size,
    launchesSuccessFull = success?: false,
    imageLaunch = links.patch.small ?: "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg"

)

fun Launch.toLaunchHome() = LatestLaunchHome(
    reused = fairings?.reused ?: false,
    image = links.patch.small ?: "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg",
    name = name,
    capsules = capsules.size,
    cores = cores.size,
    id = id,
    timeUnix = date_unix

)