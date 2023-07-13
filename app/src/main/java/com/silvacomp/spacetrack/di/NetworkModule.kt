package com.silvacomp.spacetrack.di

import com.silvacomp.spacetrack.common.SpaceXApi
import com.silvacomp.spacetrack.launches.data.repository.LaunchesRepositoryImpl
import com.silvacomp.spacetrack.launches.domain.repository.LaunchesRepository
import com.silvacomp.spacetrack.launches.domain.uses_cases.LatestLaunchUseCase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides

    fun provideRetrofit(): SpaceXApi{


        val httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(80, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)

        return Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl("https://api.spacexdata.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(SpaceXApi::class.java)
    }





    
}