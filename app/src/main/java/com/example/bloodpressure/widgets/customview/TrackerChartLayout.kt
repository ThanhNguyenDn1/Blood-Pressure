package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.databinding.LayoutTrackerChartBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class TrackerChartLayout : ConstraintLayout {

    private var binding: LayoutTrackerChartBinding
    private var items: ArrayList<BarEntry>
    private lateinit var xAxis: XAxis
    private lateinit var yAxis: YAxis

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )


    init {
        binding = LayoutTrackerChartBinding.inflate(LayoutInflater.from(context), this, false)
        items = ArrayList()
        addView(binding.root)
        initBarChart()
    }

    private fun initBarChart() {
        val xAxis: XAxis
        binding.bcTracker.apply {
            setScaleEnabled(false)
            setMaxVisibleValueCount(7)
            setDrawValueAboveBar(false)
            getXAxis().setDrawAxisLine(false);
            setDrawGridBackground(false);
            getXAxis().setDrawGridLines(false);
            getAxisLeft().setDrawGridLines(false);
            getAxisRight().setDrawGridLines(false);
            //  getAxisLeft().setEnabled(false);
            getAxisRight().setEnabled(false);
            getLegend().setEnabled(false);
            setPinchZoom(false);
            setDescription(null);
            setTouchEnabled(false);
            setDoubleTapToZoomEnabled(false);
            setExtraOffsets(20f, 0f, 0f, 30f);
            xAxis = getXAxis()
            yAxis = axisLeft
        }
        xAxis.apply {
            setPosition(XAxis.XAxisPosition.BOTTOM);
            setTextSize(14f);
            setTextColor(Color.BLACK);
            setYOffset(5f);
            setDrawLabels(true);
            setGranularityEnabled(true);
            setGranularity(1f);
            setXOffset(30f);
            setCenterAxisLabels(true);
            setLabelCount(7)
        }


        yAxis.apply {
            setDrawGridLines(false)
            //typeface = tfLight
            setLabelCount(5, false)
           // valueFormatter = custom
            spaceTop = 15f
            axisMinimum = 20f
        }
    }

    fun updateData(it: List<BloodPressure>?) {
        for (i in 0..it!!.size - 1) {
            items.add(BarEntry(i.toFloat(), it[i].systolic.toFloat()))
        }
        val barDataSet = BarDataSet(items, "").apply {
            setValueTextColor(Color.BLACK);
            setDrawValues(false);
        }
        val barData = BarData(barDataSet)
        binding.bcTracker.apply {
            data = barData
            invalidate()
        }
    }

}