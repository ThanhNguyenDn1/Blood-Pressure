package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
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
    private var dates = arrayListOf("", "", "", "")
    private var monthDays = geMonthDay()

    init {
        binding = LayoutCalendarPickerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        initData()
        handlerEvent()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
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


            val year = Calendar.getInstance().get(Calendar.YEAR)
            maxValue = year
            minValue = year - 6
            value = year
            dates.set(0, year.toString())
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


            maxValue = 59
            minValue = 0
            val c = Calendar.getInstance()
            value = c.get(Calendar.HOUR_OF_DAY)
            dates.set(2, value.toString())
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

            maxValue = 59
            minValue = 0
            val c = Calendar.getInstance()
            value = c.get(Calendar.MINUTE)
            dates.set(3, value.toString())
        }

    }

    fun handlerEvent() {
        binding.npvYear.apply {
            setOnValueChangedListener(object : OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    dates.set(0, newVal.toString())
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
                    dates.set(2, newVal.toString())
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
                    dates.set(3, newVal.toString())
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

    fun setParameter(dates: ArrayList<String>) {
        this.dates = dates
        binding.apply {
            npvMinute.value = dates[3].toInt()
            npvTime.value = dates[2].toInt()
            npvMonthDay.value = monthDays.indexOf(dates[1]) + 1
            npvYear.value = dates[0].toInt()
        }
        callBack.onCalendarPickeChange(dates)
    }

    fun addCallBack(callBack: ListenerCalendarPicker) {
        this.callBack = callBack
    }
}