package com.example.data.repository

import android.content.Context
import com.example.domain.models.ChartData
import com.example.domain.repository.AssetsRepository
import com.google.gson.Gson
import javax.inject.Inject

class AssetsRepositoryImpl @Inject constructor(
    private val gson: Gson,
    private val context: Context
) : AssetsRepository {

    override suspend fun getChartData(jsonPath: String): ChartData = retrieveModel(jsonPath, context)

    private fun retrieveModel(jsonPath: String, context: Context) =
        gson.fromJson(getJsonString(jsonPath, context), ChartData::class.java)

    private fun getJsonString(jsonPath: String, context: Context): String {
        val input = context.assets.open(jsonPath)
        val buf = ByteArray(input.available())
        input.read(buf)
        input.close()
        return String(buf)
    }
}