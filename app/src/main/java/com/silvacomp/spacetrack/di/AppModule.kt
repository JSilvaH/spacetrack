package com.silvacomp.spacetrack.di

import com.silvacomp.spacetrack.capsules.data.repository.CapsuleRepositoryImpl
import com.silvacomp.spacetrack.capsules.domain.repository.CapsuleRepository
import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.crew.data.respository.CrewRepositoryImpl
import com.silvacomp.spacetrack.crew.domain.respository.CrewRepository
import com.silvacomp.spacetrack.dragons.data.repository.DragonRepositoryImpl
import com.silvacomp.spacetrack.dragons.domain.models.DragonDomain
import com.silvacomp.spacetrack.dragons.domain.repository.DragonRepository
import com.silvacomp.spacetrack.launches.data.repository.LaunchesRepositoryImpl
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import com.silvacomp.spacetrack.launchpads.data.repository.LaunchpadRepositoryImpl
import com.silvacomp.spacetrack.launchpads.domain.repository.LaunchpadRepository
import com.silvacomp.spacetrack.rockets.data.repository.RocketsRepositoryImpl
import com.silvacomp.spacetrack.rockets.domain.repository.RocketsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLaunchesRepository(api: SpaceXApi): LaunchesRepository {
        return LaunchesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCapsulesRepository(api: SpaceXApi): CapsuleRepository{
        return  CapsuleRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCrewRepository(api:SpaceXApi): CrewRepository{
        return  CrewRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRocketRepository(api: SpaceXApi): RocketsRepository{
        return  RocketsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDragonRepository(api: SpaceXApi): DragonRepository{
        return DragonRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLaunchpadRepository(api: SpaceXApi): LaunchpadRepository{
        return LaunchpadRepositoryImpl(api)
    }






}