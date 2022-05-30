package com.example.chartapplication.di.component

import com.example.chartapplication.ChartApplication
import com.example.chartapplication.di.modules.*
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    FragmentModule::class,
    InteractorModule::class,
    MapperModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class])

interface ApplicationComponent : AndroidInjector<ChartApplication>