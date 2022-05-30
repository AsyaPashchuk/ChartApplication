package com.example.chartapplication.feature.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chartapplication.databinding.FragmentWeekBinding
import com.example.chartapplication.feature.BaseChartFragment
import com.example.chartapplication.feature.ChartViewModel
import com.example.chartapplication.utils.ChartTypeEnum
import com.github.mikephil.charting.charts.LineChart

class WeekChartFragment : BaseChartFragment() {

    private lateinit var viewModel: ChartViewModel
    private lateinit var weekLineChartView: LineChart

    private var _binding: FragmentWeekBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = getViewModel()
        _binding = FragmentWeekBinding.inflate(inflater, container, false)
        val root: View = binding.root

        weekLineChartView = binding.weekChart
        createChartView(weekLineChartView, false)
        observeVM()

        return root
    }

    override fun observeVM() {
        viewModel.weekChartLD.observe(viewLifecycleOwner) { data ->
            setChartData(
                data[ChartTypeEnum.AAPL.ordinal],
                data[ChartTypeEnum.MSFT.ordinal],
                data[ChartTypeEnum.SPY.ordinal],
                weekLineChartView
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}