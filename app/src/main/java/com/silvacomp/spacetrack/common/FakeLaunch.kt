package com.silvacomp.spacetrack.common

import com.silvacomp.spacetrack.launches.data.remote.*

object FakeLaunch {
    private val launch = Launch(
        fairings = null,
        links = Links(
            "PEPE",
            Flickr(emptyList(), emptyList()),
            Patch("", ""),
            null,
            Reddit(null, null, null, null),
            "",
            "",
            ""
        ),
        static_fire_date_unix = null,
        static_fire_date_utc = null,
        net = false,
        window = null,
        rocket = "5e9d0d95eda69973a809d1ec",
        success = true,
        failures = emptyList(),
        details = null,
        crew = listOf(
            "62dd7196202306255024d13c",
            "62dd71c9202306255024d13d",
            "62dd7210202306255024d13e",
            "62dd7253202306255024d13f"
        ),
        ships = emptyList(),
        capsules = listOf(
            "617c05591bad2c661a6e2909"
        ),
        payloads = listOf(
            "62dd73ed202306255024d145"
        ),
        launchpad = "5e9e4502f509094188566f88",
        flight_number = 187,
        name = "Crew-5",
        date_utc = "2022-10-05T16:00:00.000Z",
        date_unix = 1664985600,
        date_local = "2022-10-05T12:00:00-04:00",
        date_precision = "hour",
        upcoming = false,
        cores = emptyList(),
        auto_update = true,
        tbd = false,
        launch_library_id = "f33d5ece-e825-4cd8-809f-1d4c72a2e0d3",
        id = "62dd70d5202306255024d139"
    )

    fun  getLaunch(): Launch{
        return launch
    }
}