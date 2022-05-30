package com.example.chartapplication.feature

import android.graphics.Color
import android.graphics.DashPathEffect
import com.example.chartapplication.core.base.BaseFragment
import com.example.chartapplication.utils.ChartTypeEnum
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseChartFragment : BaseFragment() {

    fun createChartView(lineChartView: LineChart, isMonth: Boolean) {
        lineChartView.apply {
            setBackgroundColor(Color.WHITE)
            setTouchEnabled(false)
            description.isEnabled = false
            setTouchEnabled(true)
            animateX(500)
            setScaleEnabled(true)
            isDragEnabled = true
            setPinchZoom(true)
        }

        lineChartView.legend.apply {
            form = Legend.LegendForm.CIRCLE
        }

        lineChartView.xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            setLabelCount(24, false)
            valueFormatter = object : ValueFormatter() {
                private val dateFormat = if (!isMonth) SimpleDateFormat("HH:mm") else SimpleDateFormat("dd.MM")
                override fun getFormattedValue(value: Float): String {
                    return dateFormat.format(Date(value.toLong() * 1000L))
                }
            }
        }

        lineChartView.axisLeft.apply{
            setLabelCount(5, false)
            setDrawAxisLine(true)
        }
    }

    private fun chartDataSettings(values: LineDataSet) {
        values.apply {
            setDrawCircles(true)
            setDrawCircleHole(true)
            setDrawValues(true)
            lineWidth = 1f
            formLineWidth = 1f
            enableDashedLine(5f, 5f, 0f)
            formLineDashEffect = DashPathEffect(floatArrayOf(6f, 3f), 0f)
            formSize = 6f
            valueTextSize = 6f
            setDrawFilled(false)
        }
    }

    fun setChartData(aaplDataValues: List<Entry>, msftDataValues: List<Entry>, spyDataValues: List<Entry>, lineChartView: LineChart) {
        val aaplDataSet = LineDataSet(aaplDataValues, ChartTypeEnum.AAPL.name)
        val msftDataSet = LineDataSet(msftDataValues, ChartTypeEnum.MSFT.name)
        val spyDataSet = LineDataSet(spyDataValues, ChartTypeEnum.SPY.name)
        val chartDataSets = ArrayList<ILineDataSet>()

        aaplDataSet.apply {
            color = Color.BLUE
            setCircleColor(Color.BLUE)
        }
        chartDataSettings(aaplDataSet)

        msftDataSet.apply {
            color = Color.MAGENTA
            setCircleColor(Color.MAGENTA)
        }
        chartDataSettings(msftDataSet)

        spyDataSet.apply {
            color = Color.CYAN
            setCircleColor(Color.CYAN)
        }
        chartDataSettings(spyDataSet)

        chartDataSets.add(aaplDataSet)
        chartDataSets.add(msftDataSet)
        chartDataSets.add(spyDataSet)

        val data = LineData(chartDataSets)
        lineChartView.data = data
        lineChartView.invalidate()
    }
}