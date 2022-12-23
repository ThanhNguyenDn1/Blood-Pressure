package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.bloodpressure.R


class LineDashed : View {
    private var paint: Paint
    private var path: Path
    private var mW = 0f
    private var mH = 0f

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        paint = Paint()
        paint.pathEffect = DashPathEffect(floatArrayOf(5f, 5f), 0F)
        paint.apply {
            setStyle(Paint.Style.STROKE)
            strokeWidth=2f
            color = ContextCompat.getColor(context, R.color.white_70)
        }
        path = Path()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mW = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        mH = MeasureSpec.getSize(heightMeasureSpec).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawLine(canvas)
    }

    private fun drawLine(canvas: Canvas?) {
        path.moveTo(0f, mH / 2)
        path.lineTo(mW, mH / 2)
        canvas!!.drawPath(path, paint)
    }

}