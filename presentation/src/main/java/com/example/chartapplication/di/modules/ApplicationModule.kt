package com.example.chartapplication.di.modules

import android.app.Application
import android.content.Context
import com.example.chartapplication.ChartApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: ChartApplication) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = application

    @Provides
    @Singleton
    fun provideApplication(): Application = application
}