package com.example.chartapplication.di.modules

import com.example.chartapplication.feature.interactors.ChartInteractor
import com.example.chartapplication.feature.interactors.ChartInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun getChartInteractor(chartInteractorImpl: ChartInteractorImpl): ChartInteractor = chartInteractorImpl
}