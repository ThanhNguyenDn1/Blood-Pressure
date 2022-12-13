package com.example.bloodpressure.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.example.bloodpressure.R

class RadiusCardView(context: Context, attrs: AttributeSet?) : CardView(context, attrs) {

    var bottomRightRadius = 1.0f

    var topRightRadius = 1.0f

    var topLeftRadius = 1.0f


    var bottomLeftRadius = 1.0f

    val path = Path()


    private val rectF: RectF
        get() {
            val rect = Rect()
            getDrawingRect(rect)
            return RectF(rect)
        }

    override fun onDraw(canvas: Canvas) {
        path.reset()
        val rectF: RectF = rectF
        val f = bottomRightRadius
        val f2 = topRightRadius
        val f3 = topLeftRadius
        val f4 = bottomLeftRadius
        path.addRoundRect(rectF, floatArrayOf(f, f, f2, f2, f3, f3, f4, f4), Path.Direction.CW)
        canvas.clipPath(path, Region.Op.INTERSECT)
        super.onDraw(canvas)
    }

    init {
        setRadius(0.0f)
        val obtainStyledAttributes: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.RadiusCardView)
        bottomRightRadius =
            obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_bottomRightRadius, 1.0f)
        topRightRadius =
            obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_topRightRadius, 1.0f)
        topLeftRadius =
            obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_topLeftRadius, 1.0f)
        bottomLeftRadius =
            obtainStyledAttributes.getDimension(R.styleable.RadiusCardView_bottomLeftRadius, 1.0f)
        obtainStyledAttributes.recycle()
        setBackground(ColorDrawable())
    }
}