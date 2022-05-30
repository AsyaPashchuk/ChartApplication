package com.example.domain.usecases

import com.example.domain.core.UseCase
import com.example.domain.models.ChartData
import com.example.domain.repository.AssetsRepository
import javax.inject.Inject

class GetChartDataUseCase @Inject constructor(
    private val repository: AssetsRepository
) : UseCase<String, ChartData> {

    override suspend fun execute(param: String) = repository.getChartData(param)
}