package com.example.bloodpressure.utils

import com.example.bloodpressure.R

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


    fun getStage(): Int {

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

    fun getStageRange(): Int {
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

    fun getStageContent(): Int {
        val ordinal = ordinal
        if (ordinal == 0) {
            return R.string.hypotension_content
        }
        if (ordinal == 1) {
            return R.string.normal_content
        }
        if (ordinal == 2) {
            return R.string.elevated_content
        }
        if (ordinal == 3) {
            return R.string.hypertension_1_content
        }
        if (ordinal == 4) {
            return R.string.hypertension_2_content
        }
        if (ordinal == 5) {
            return R.string.hypertensive_content
        }
        throw IllegalArgumentException()
    }

    fun getColorStage(): Int {
        val ordinal = ordinal
        if (ordinal == 0) {
            return R.color.stage_hypotension_top
        }
        if (ordinal == 1) {

            return R.color.stage_normal_top
        }
        if (ordinal == 2) {
            return R.color.stage_elevated_top
        }
        if (ordinal == 3) {
            return R.color.stage_hypotension_1_top
        }
        if (ordinal == 4) {
            return R.color.stage_hypotension_2_top
        } else {
            return R.color.stage_hypotensive_top
        }
    }
}