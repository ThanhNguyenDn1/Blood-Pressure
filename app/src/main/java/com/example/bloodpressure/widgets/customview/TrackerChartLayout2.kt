package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.bloodpressure.utils.Stage


class TrackerChartLayout2 : View {
    private var paddingLeft = 100f
    private var paddingVertical = 50f
    private var padding = 5f
    private var paint: Paint
    private var paintCl: Paint
    private var path: Path
    private var stage: Stage
    private var mH = 0f
    private var mW = 0f
    private lateinit var rectF: RectF

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    init {
        stage = Stage.STAGE_NORMAL

        //paint draw colum chart
        paint = Paint()
        paint.apply {
            color = Color.WHITE
            setDither(true);
            setStyle(Paint.Style.STROKE);
            setStrokeJoin(Paint.Join.ROUND);
            setStrokeCap(Paint.Cap.ROUND);
            setStrokeWidth(3f);
        }


        //rectF
        rectF = RectF(0f, 0f, mW, mH)


        //pain draw text chart
        paintCl = Paint()
        paintCl.pathEffect = DashPathEffect(floatArrayOf(5f, 5f), 0F)
        paintCl.apply {
            setStyle(Paint.Style.STROKE)
            strokeWidth = 3f
            color = Color.WHITE
            setAlpha(0.5f)
        }
        path = Path()


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mH = (MeasureSpec.getSize(heightMeasureSpec) - padding)
        mW = (MeasureSpec.getSize(widthMeasureSpec) - padding)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawLine()
        canvas!!.drawPath(path, paintCl)

    }

    private fun drawLine() {
        val spaceItem = (mH - 2 * paddingVertical) / 4
        for (i in 0..4) {
            path.moveTo(paddingLeft, i * spaceItem + paddingVertical)
            path.lineTo(mW, i * spaceItem + paddingVertical)

        }
    }

}