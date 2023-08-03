package com.silvacomp.spacetrack.common

import com.silvacomp.spacetrack.capsules.data.remote.Capsule
import com.silvacomp.spacetrack.crew.data.remote.CrewMember
import com.silvacomp.spacetrack.dragons.data.remote.DragonsItem
import com.silvacomp.spacetrack.launches.data.remote.Launch
import com.silvacomp.spacetrack.launches.data.remote.LaunchesQuery
import com.silvacomp.spacetrack.launchpads.data.remote.LaunchpadsItem
import com.silvacomp.spacetrack.rockets.data.remote.Rockets
import com.silvacomp.spacetrack.rockets.data.remote.RocketsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApi {

    @GET("v4/launches")
    suspend fun getLaunches(): List<Launch>

    @GET("v4/launches/{id}")
    suspend fun getOneLaunch(@Path("id") id:String): Launch

    @GET("/v4/launches/latest")
    suspend fun getLatestLaunch(): Launch

    @GET("/v4/launches/next")
    suspend fun getNextLaunch(): Launch

    @GET("/v4/rockets/")
    suspend fun getAllRocket():  List<RocketsItem>

    @GET("/v4/rockets/{id}")
    suspend fun getOneRocket(@Path("id") id:String): RocketsItem

    @GET("/v4/crew/")
    suspend fun getAllCrew(): List<CrewMember>

    @GET("/v4/crew/{id}")
    suspend fun  getOneCrewMember(@Path("id") id: String) : CrewMember

    @GET("/v4/capsules/")
    suspend fun getAllCapsules(): List<Capsule>

    @GET("/v4/capsules/{id}")
    suspend fun getOneCapsule(@Path("id") id: String): Capsule

    @GET("/v4/dragons/")
    suspend fun getDragon(): List<DragonsItem>

    @GET("/v4/launchpads")
    suspend fun getLaunchpads(): List<LaunchpadsItem>
}