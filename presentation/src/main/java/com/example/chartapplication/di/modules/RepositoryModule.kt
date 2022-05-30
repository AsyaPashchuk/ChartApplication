package com.example.chartapplication.di.modules

import com.example.data.repository.AssetsRepositoryImpl
import com.example.domain.repository.AssetsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideChartRepository(repositoryImpl: AssetsRepositoryImpl): AssetsRepository= repositoryImpl
}