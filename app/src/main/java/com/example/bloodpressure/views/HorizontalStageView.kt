package com.example.bloodpressure.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.bloodpressure.R
import com.example.bloodpressure.databinding.LayoutHorizatalStageBinding

class HorizontalStageView(context: Context?, attrs: AttributeSet?) :
    ConstraintLayout(context!!, attrs) {
    private var binding: LayoutHorizatalStageBinding
    private lateinit var state: Stage

    init {
        binding = LayoutHorizatalStageBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)
        state = Stage.STAGE_NORMAL
        initView()

    }

    private fun initView() {
        binding.healthGoals.text=context.getString(state.healthGoals())
    }


    enum class Stage {
        STAGE_HYPOTENSION, STAGE_NORMAL, STAGE_ELEVATED, STAGE_HYPERTENSION_1, STAGE_HYPERTENSION_2, STAGE_HYPERTENSIVE;

        fun getStatusHealth(i: Int, i2: Int): Stage {
            var z = true
            if (90 <= i && i < 120) {
                if (60 <= i2 && i2 < 80) {
                    return STAGE_NORMAL
                }
            }
            if (120 <= i && i < 130) {
                if (60 > i2 || i2 >= 80) {
                    z = false
                }
                if (z) {
                    return STAGE_ELEVATED
                }
            }
            return if (i >= 130 || i2 >= 80) if (i >= 140 || i2 >= 90) if (i > 180 || i2 > 120) STAGE_HYPERTENSIVE else STAGE_HYPERTENSION_2 else STAGE_HYPERTENSION_1 else STAGE_HYPOTENSION
        }


        fun getTitle(): Int {
            val ordinal = ordinal
            if (ordinal == 0) {
                return R.string.hypotension
            }
            if (ordinal == 1) {
                return R.string.normal_leg
            }
            if (ordinal == 2) {
                return R.string.elevated
            }
            if (ordinal == 3) {
                return R.string.hypertension_1
            }
            if (ordinal == 4) {
                return R.string.hypertension_2
            } else {
                return R.string.hypertensive
            }

        }

        fun healthGoals(): Int {
            val ordinal = ordinal
            if (ordinal == 0) {
                return R.string.range_hypotension
            }
            if (ordinal == 1) {
                return R.string.range_normal
            }
            if (ordinal == 2) {
                return R.string.range_elevated
            }
            if (ordinal == 3) {
                return R.string.range_hypertension_1
            }
            if (ordinal == 4) {
                return R.string.range_hypertension_2
            }
            if (ordinal == 5) {
                return R.string.range_hypertensive
            }
            throw IllegalArgumentException()
        }

    }
}