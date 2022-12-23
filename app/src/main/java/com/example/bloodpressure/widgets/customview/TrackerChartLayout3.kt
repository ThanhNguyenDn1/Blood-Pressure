package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodpressure.adapter.BarChartAdapter
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.databinding.LayoutBarchartBinding


class TrackerChartLayout3 : ConstraintLayout {

    private  var binding: LayoutBarchartBinding
    private lateinit var adapter: BarChartAdapter

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        binding = LayoutBarchartBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        initData()
        iniView()
    }

    private fun initData() {
        adapter = BarChartAdapter(arrayListOf(), context)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
    private fun iniView() {
        var mLayoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        mLayoutManager.stackFromEnd=true
        binding.apply {
            rvBarChart.apply {
                adapter = this@TrackerChartLayout3.adapter
                layoutManager =mLayoutManager
                overScrollMode= OVER_SCROLL_NEVER
            }
        }
    }

    fun updateData(data: List<BloodPressure>) {
        this.adapter.updateData(data)
    }
}