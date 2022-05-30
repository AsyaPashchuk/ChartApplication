package com.example.chartapplication.feature

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.chartapplication.core.base.BaseViewModel
import com.example.chartapplication.extensions.mutable
import com.example.chartapplication.feature.interactors.ChartInteractor
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ChartViewModel @Inject constructor(
    application: Application,
    private val chartInteractor: ChartInteractor
) : BaseViewModel(application) {

    val weekChartLD = mutable<List<List<Entry>>>()
    val monthChartLD = mutable<List<List<Entry>>>()

    init {
        getWeekChartData()
        getMonthChartData()
    }

    private fun getWeekChartData() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = chartInteractor.getChart("week_data.json")
            weekChartLD.postValue(result)
        } catch (ex: Exception) {
            Log.e("errr", ex.message ?: "")
            //TODO define how to handle errors
        }
    }

    private fun getMonthChartData() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = chartInteractor.getChart("month_data.json")
            monthChartLD.postValue(result)
        } catch (ex: Exception) {
            Log.e("errr", ex.message ?: "")
            //TODO define how to handle errors
        }
    }

}