package com.silvacomp.spacetrack.launchpads.data.mappers

import com.silvacomp.spacetrack.launchpads.data.remote.LaunchpadsItem
import com.silvacomp.spacetrack.launchpads.domain.model.LaunchpadDomain

fun LaunchpadsItem.toDomain() = LaunchpadDomain(
    name = fullName,
    details = details,
    numberLaunches = launches.size,
    landingAttempts = landingAttempts,
    landingSuccess = landingSuccesses,
    locality = locality,
    region = region,
    status = status,
    image = images.large[0]
)