package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.ListenerCalendarPicker
import com.example.bloodpressure.databinding.LayoutCalendarPickerBinding
import com.shawnlin.numberpicker.NumberPicker
import com.shawnlin.numberpicker.NumberPicker.OnScrollListener
import com.shawnlin.numberpicker.NumberPicker.OnScrollListener.SCROLL_STATE_IDLE
import com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener
import java.text.SimpleDateFormat
import java.util.*


class CalendarPickerView(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {
    private var binding: LayoutCalendarPickerBinding
    private lateinit var callBack: ListenerCalendarPicker
    private var dates = arrayOf("", "", "", "")
    private var years = getYear()
    private var monthDays = geMonthDay()
    private var hours = getHours()
    private var minutes = getMinute()

    init {
        binding = LayoutCalendarPickerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        initData()
        handlerEvent()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        Log.d("22222", "view")
        callBack.onCalendarPickeChange(dates)
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

            displayedValues = years
            val s = years.size
            maxValue = s
            minValue = 1
            value = s
            dates.set(0, years[value - 1])
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

            displayedValues = monthDays
            val s = monthDays.size
            maxValue = s
            minValue = 1
            val c = Calendar.getInstance()
            value = c.get(Calendar.DAY_OF_YEAR)
            dates.set(1, monthDays[value - 1])
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
            displayedValues = hours
            val s = hours.size
            maxValue = s
            minValue = 1
            val c = Calendar.getInstance()
            value = c.get(Calendar.HOUR_OF_DAY) + 1
            dates.set(2, hours[value - 1])
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
            displayedValues = minutes
            val s = minutes.size
            maxValue = s
            minValue = 1
            val c = Calendar.getInstance()
            value = c.get(Calendar.MINUTE) + 1
            dates.set(3, minutes[value - 1])
        }

    }

    fun handlerEvent() {
        binding.npvYear.apply {
            setOnValueChangedListener(object : OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    dates.set(0, years[newVal - 1])
                }
            })
            setOnScrollListener(object : OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onCalendarPickeChange(dates)
                    }
                }
            })
        }
        binding.npvMonthDay.apply {
            setOnValueChangedListener(object : OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    dates.set(1, monthDays[newVal - 1])
                }
            })
            setOnScrollListener(object : OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onCalendarPickeChange(dates)
                    }
                }
            })
        }
        binding.npvTime.apply {
            setOnValueChangedListener(object : OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    dates.set(2, hours[newVal - 1])
                }
            })
            setOnScrollListener(object : OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onCalendarPickeChange(dates)
                    }
                }
            })
        }
        binding.npvMinute.apply {
            setOnValueChangedListener(object : OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    dates.set(3, minutes[newVal - 1])
                }
            })
            setOnScrollListener(object : OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onCalendarPickeChange(dates)
                    }
                }
            })
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

    fun geMonthDay(): Array<String> {
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

    fun getYear(): Array<String> {
        val minYear = Calendar.getInstance().get(Calendar.YEAR) - 6
        val data = Array(7) { i ->
            (minYear + i).toString()
        }
        return data
    }

    fun addCallBack(callBack: ListenerCalendarPicker) {
        this.callBack = callBack
    }
}