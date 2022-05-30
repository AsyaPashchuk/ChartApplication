package com.example.chartapplication.feature.interactors

import com.example.chartapplication.mappers.ChartDataMapper
import com.example.domain.usecases.GetChartDataUseCase
import com.github.mikephil.charting.data.Entry
import javax.inject.Inject

class ChartInteractorImpl @Inject constructor(
    private val getChartDataUseCase: GetChartDataUseCase,
    private val chartDataMapper: ChartDataMapper
) : ChartInteractor {

    override suspend fun getChart(file: String): List<List<Entry>> {
        val chartData = getChartDataUseCase.execute(file)
        return chartDataMapper.map(chartData)
    }
}