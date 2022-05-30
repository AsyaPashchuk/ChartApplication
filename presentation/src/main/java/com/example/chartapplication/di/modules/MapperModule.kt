package com.example.chartapplication.di.modules

import com.example.chartapplication.mappers.ChartDataMapper
import com.example.domain.core.Mapper
import com.example.domain.models.ChartData
import com.github.mikephil.charting.data.Entry
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun getChartDataMapper(chartDataMapper: ChartDataMapper): Mapper<ChartData, List<List<Entry>>> = chartDataMapper
}