package com.example.domain.repository

import com.example.domain.models.ChartData

interface AssetsRepository {

    suspend fun getChartData(jsonPath: String): ChartData
}