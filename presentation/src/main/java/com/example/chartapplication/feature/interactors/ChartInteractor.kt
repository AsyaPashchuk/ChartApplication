package com.example.chartapplication.feature.interactors

import com.github.mikephil.charting.data.Entry

interface ChartInteractor {

    suspend fun getChart(file: String): List<List<Entry>>
}