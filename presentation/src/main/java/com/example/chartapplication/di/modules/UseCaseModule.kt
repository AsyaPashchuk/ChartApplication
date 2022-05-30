package com.example.chartapplication.di.modules

import com.example.domain.core.UseCase
import com.example.domain.models.ChartData
import com.example.domain.usecases.GetChartDataUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getChartDataUseCase(getChartDataUseCase: GetChartDataUseCase): UseCase<String, ChartData> = getChartDataUseCase
}