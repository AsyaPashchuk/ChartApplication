package com.example.chartapplication.feature.month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chartapplication.databinding.FragmentMonthBinding
import com.example.chartapplication.feature.BaseChartFragment
import com.example.chartapplication.feature.ChartViewModel
import com.example.chartapplication.utils.ChartTypeEnum
import com.github.mikephil.charting.charts.LineChart

class MonthChartFragment : BaseChartFragment() {

    private lateinit var viewModel: ChartViewModel
    private lateinit var monthLineChartView: LineChart

    private var _binding: FragmentMonthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getViewModel()
        _binding = FragmentMonthBinding.inflate(inflater, container, false)
        val root: View = binding.root

        monthLineChartView = binding.monthChart
        createChartView(monthLineChartView, true)
        observeVM()
        return root
    }

    override fun observeVM() {
        viewModel.monthChartLD.observe(viewLifecycleOwner) { data ->
            setChartData(
                data[ChartTypeEnum.AAPL.ordinal],
                data[ChartTypeEnum.MSFT.ordinal],
                data[ChartTypeEnum.SPY.ordinal],
                monthLineChartView
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}