package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.ListenerRecordPicker
import com.example.bloodpressure.databinding.LayoutRecordPickerBinding
import com.shawnlin.numberpicker.NumberPicker
import com.shawnlin.numberpicker.NumberPicker.OnScrollListener.SCROLL_STATE_IDLE

class RecordPickerView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: LayoutRecordPickerBinding
    private lateinit var callBack: ListenerRecordPicker
    private var datas = ArrayList<Int>()
    private val SYSTOLIC_DEFAULT = 100
    private val DIASTOLIC_DEFAULT = 75
    private val PULSE_DEFAULT = 70
    private val SYSTOLIC_DIASTOLIC_MAX = 300
    private val PULSE_MAX = 200
    private val VALUE_MIN = 20

    init {
        binding = LayoutRecordPickerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        datas.addAll(arrayListOf(SYSTOLIC_DEFAULT, DIASTOLIC_DEFAULT, PULSE_DEFAULT))
        initView()
        handlerEvent()
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        callBack.onRecordPickerChange(datas)
    }

    private fun handlerEvent() {
        binding.npk1.apply {
            setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    datas[0] = newVal
                }
            })

            setOnScrollListener(object : NumberPicker.OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onRecordPickerChange(datas)
                    }
                }
            })
        }

        binding.npk2.apply {
            setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    datas[1] = newVal
                }
            })
            setOnScrollListener(object : NumberPicker.OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onRecordPickerChange(datas)
                    }
                }
            })
        }
        binding.npk3.apply {
            setOnValueChangedListener(object : NumberPicker.OnValueChangeListener {
                override fun onValueChange(picker: NumberPicker?, oldVal: Int, newVal: Int) {
                    datas[2] = newVal
                }
            })
            binding.npk3.setOnScrollListener(object : NumberPicker.OnScrollListener {
                override fun onScrollStateChange(view: NumberPicker?, scrollState: Int) {
                    if (scrollState == SCROLL_STATE_IDLE) {
                        callBack.onRecordPickerChange(datas)
                    }
                }
            })
        }
    }

    private fun initView() {
        binding.npk1.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            value = SYSTOLIC_DEFAULT
            maxValue = SYSTOLIC_DIASTOLIC_MAX
            minValue = VALUE_MIN
        }
        binding.npk2.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            value = DIASTOLIC_DEFAULT
            maxValue = SYSTOLIC_DIASTOLIC_MAX
            minValue = VALUE_MIN
        }
        binding.npk3.apply {
            setSelectedTypeface(
                Typeface.create(
                    ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
                )
            )
            typeface = Typeface.create(
                ResourcesCompat.getFont(context, R.font.assistant_extra_bold), Typeface.BOLD
            )
            value = PULSE_DEFAULT
            maxValue = PULSE_MAX
            minValue = VALUE_MIN
        }
    }

    fun addCallBack(callBack: ListenerRecordPicker) {
        this.callBack = callBack
    }

    fun setRecord(datas:ArrayList<Int>) {
        this.datas=datas
        binding.apply {
            npk1.value = datas[0]
            npk2.value = datas[1]
            npk3.value = datas[2]
        }
        callBack.onRecordPickerChange(this.datas)
    }

}
