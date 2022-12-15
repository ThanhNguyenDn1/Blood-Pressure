package com.example.bloodpressure.views

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bloodpressure.callBack.ListenerHorizontalStage
import com.example.bloodpressure.databinding.LayoutHorizatalStageBinding
import com.example.bloodpressure.utils.Stage

class HorizontalStageView(context: Context?, attrs: AttributeSet?) :
    ConstraintLayout(context!!, attrs) {
    private var binding: LayoutHorizatalStageBinding
    private var stage: Stage
    private lateinit var callBack: ListenerHorizontalStage

    init {
        binding = LayoutHorizatalStageBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        stage = Stage.STAGE_NORMAL
    }

    fun updateData(systolic: Int = 100, diastolic: Int = 75, pulse: Int = 70) {
        stage = stage.getStatusHealth(systolic, diastolic)
        callBack.onChangeStage(
            stage.getStage(), stage.getStageRange(), stage.getStageContent(), stage.getColorStage()
        )
        updateView(stage.ordinal)
    }

    private fun updateView(ordinal: Int) {
        binding.apply {
            view1.isSelected = if (ordinal == 0) true else false
            view2.isSelected = if (ordinal == 1) true else false
            view3.isSelected = if (ordinal == 2) true else false
            view4.isSelected = if (ordinal == 3) true else false
            view5.isSelected = if (ordinal == 4) true else false
            view6.isSelected = if (ordinal == 5) true else false

            triangle1.visibility = if (ordinal == 0) VISIBLE else INVISIBLE
            triangle2.visibility = if (ordinal == 1) VISIBLE else INVISIBLE
            triangle3.visibility = if (ordinal == 2) VISIBLE else INVISIBLE
            triangle4.visibility = if (ordinal == 3) VISIBLE else INVISIBLE
            triangle5.visibility = if (ordinal == 4) VISIBLE else INVISIBLE
            triangle6.visibility = if (ordinal == 5) VISIBLE else INVISIBLE
        }
    }

    fun addCallBack(callBack: ListenerHorizontalStage) {
        this.callBack = callBack
    }
}