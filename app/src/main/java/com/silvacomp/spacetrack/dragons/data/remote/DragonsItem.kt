package com.silvacomp.spacetrack.dragons.data.remote


import androidx.annotation.Keep
import com.squareup.moshi.Json
@Keep
data class DragonsItem(
    @Json(name = "active")
    val active: Boolean,
    @field:Json(name = "crew_capacity")
    val crewCapacity: Int,
    @Json(name = "description")
    val description: String,
    @Json(name = "diameter")
    val diameter: Diameter,
    @field:Json(name = "dry_mass_kg")
    val dryMassKg: Int,
    @field:Json(name = "dry_mass_lb")
    val dryMassLb: Int,
    @field:Json(name = "first_flight")
    val firstFlight: String,
    @field:Json(name = "flickr_images")
    val flickrImages: List<String>,
    @field:Json(name = "heat_shield")
    val heatShield: HeatShield,
    @field:Json(name = "height_w_trunk")
    val heightWTrunk: HeightWTrunk,
    @Json(name = "id")
    val id: String,
    @field:Json(name = "launch_payload_mass")
    val launchPayloadMass: LaunchPayloadMass,
    @field:Json(name = "launch_payload_vol")
    val launchPayloadVol: LaunchPayloadVol,
    @Json(name = "name")
    val name: String,
    @field:Json(name = "orbit_duration_yr")
    val orbitDurationYr: Int,
    @field:Json(name = "pressurized_capsule")
    val pressurizedCapsule: PressurizedCapsule,
    @field:Json(name = "return_payload_mass")
    val returnPayloadMass: ReturnPayloadMass,
    @field:Json(name = "return_payload_vol")
    val returnPayloadVol: ReturnPayloadVol,
    @field:Json(name = "sidewall_angle_deg")
    val sidewallAngleDeg: Int,
    @Json(name = "thrusters")
    val thrusters: List<Thruster>,
    @Json(name = "trunk")
    val trunk: Trunk,
    @Json(name = "type")
    val type: String,
    @Json(name = "wikipedia")
    val wikipedia: String
)