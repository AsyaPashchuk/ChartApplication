package com.example.chartapplication.mappers

import com.example.chartapplication.utils.ChartTypeEnum
import com.example.domain.core.Mapper
import com.example.domain.models.ChartData
import com.github.mikephil.charting.data.Entry
import javax.inject.Inject

class ChartDataMapper @Inject constructor()
    : Mapper<ChartData, List<List<Entry>>>{

    override suspend fun map(param: ChartData): List<List<Entry>> {
        val aaplChartData = mutableListOf<Entry>()
        val msftChartData = mutableListOf<Entry>()
        val spyChartData = mutableListOf<Entry>()

        val chartDataSize = param.content.quoteSymbols.first().closures.size

        val aapl = param.content.quoteSymbols[ChartTypeEnum.AAPL.ordinal]
        val msft = param.content.quoteSymbols[ChartTypeEnum.MSFT.ordinal]
        val spy = param.content.quoteSymbols[ChartTypeEnum.SPY.ordinal]

        val aaplEntryPoint = aapl.opens.first()
        val msftEntryPoint = msft.opens.first()
        val spyEntryPoint = spy.opens.first()

        for (i in 0 until chartDataSize) {
            aaplChartData.add(Entry(aapl.timestamps[i].toFloat(), calculateStock(aaplEntryPoint, aapl.opens[i])))
            msftChartData.add(Entry(msft.timestamps[i].toFloat(), calculateStock(msftEntryPoint, msft.opens[i])))
            spyChartData.add(Entry(spy.timestamps[i].toFloat(), calculateStock(spyEntryPoint, spy.opens[i])))
        }

        return mutableListOf<List<Entry>>().apply {
            add(aaplChartData)
            add(msftChartData)
            add(spyChartData)
        }
    }

    private fun calculateStock(value1: Float, value2: Float): Float{
        return Math.round(((value2 / value1) * 100) - 100).toFloat()
    }
}