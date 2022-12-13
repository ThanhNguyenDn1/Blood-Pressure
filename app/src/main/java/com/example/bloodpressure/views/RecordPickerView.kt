package com.example.bloodpressure.views

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.bloodpressure.R
import com.example.bloodpressure.databinding.LayoutRecordPickerBinding

class RecordPickerView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: LayoutRecordPickerBinding

    init {
        binding = LayoutRecordPickerBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        initView()
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
            value=100
            maxValue = 300
            minValue = 20
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
            value=75
            maxValue = 300
            minValue = 20
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
            value=70
            maxValue = 200
            minValue = 20
        }


    }

}
