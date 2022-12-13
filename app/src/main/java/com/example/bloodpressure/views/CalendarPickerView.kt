package com.example.bloodpressure.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.example.bloodpressure.R
import com.example.bloodpressure.databinding.LayoutCalendarPickerBinding
import java.text.SimpleDateFormat
import java.util.*


class CalendarPickerView : LinearLayout {
    private var binding: LayoutCalendarPickerBinding

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        binding = LayoutCalendarPickerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        initData()
    }

    private fun initData() {
        binding.npvYear.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            val minYear = Calendar.getInstance().get(Calendar.YEAR) - 6
            val data = Array(8) { i ->
                (minYear + i).toString()
            }
            displayedValues = data
            maxValue = data.size - 1
            minValue = 1
            value = 7


        }
        binding.npvMonthDay.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            val items = getTime()
            val c=Calendar.getInstance()
            displayedValues = items
            maxValue = items.size - 1
            minValue = 1
            value = c.get(Calendar.DAY_OF_YEAR)
        }
        binding.npvTime.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            val items = getHours()
            displayedValues = items
            maxValue = items.size - 1
            minValue = 1
            val c = Calendar.getInstance()
            value = c.get(Calendar.HOUR_OF_DAY) + 1
        }
        binding.npvMinute.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            val items = getMinute()
            displayedValues = items
            maxValue = items.size - 1
            minValue = 1
            val c = Calendar.getInstance()
            value = c.get(Calendar.MINUTE) + 1
        }
    }

    private fun getHours(): Array<String> {
        val item = Array(25) {
            String.format("%02d", it)
        }
        return item
    }

    private fun getMinute(): Array<String> {
        val item = Array(61) {
            String.format("%02d", it)
        }
        return item
    }


    fun getTime():Array<String> {
        val cal = Calendar.getInstance()
        val monthDay: MutableList<String> = ArrayList()
        for (m in 0..11) {
            cal.set(Calendar.MONTH, m)
            cal.set(Calendar.DAY_OF_MONTH, m)
            val maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            val df = SimpleDateFormat("MMM dd", Locale.ENGLISH)
            for (i in 0..maxDay - 1) {
                cal.set(Calendar.DAY_OF_MONTH, i + 1)
                monthDay.add(df.format(cal.getTime()))
            }
        }
        return monthDay.toTypedArray()
    }
}