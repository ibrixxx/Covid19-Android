package com.example.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import com.example.covid19.databinding.FragmentAppBinding
import com.example.covid19.databinding.FragmentStatsBinding


class StatsFragment : Fragment() {
    private lateinit var anyChartView : AnyChartView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStatsBinding>(inflater, R.layout.fragment_stats, container, false)
        anyChartView = binding.chartID
        anyChartView.setBackgroundColor("#032B28")
        setPieChart()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.statsTitle)
        return binding.root
    }

    private fun setPieChart() {
        val pie : Pie = AnyChart.pie()
        val da = arrayListOf(DataEntry())
        da.add(ValueDataEntry(getString(R.string.pfizer), 92512))
        da.add(ValueDataEntry(getString(R.string.astra), 10541))
        da.add(ValueDataEntry(getString(R.string.sputnik), 15492))
        da.add(ValueDataEntry(getString(R.string.sunnetfarm), 30857))
        da.removeAt(0)
        pie.data(da)
        anyChartView.setChart(pie)
    }

}