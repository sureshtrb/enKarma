package com.karma.sureshtrb.enKarma

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

class DynamicImageVieww : AppCompatImageView {
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context) : super(context)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = this.getDrawable()

        if (d != null) {
            // ceil not round - avoid thin vertical gaps along the left/right edges
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = ceil(
                (width * d.getIntrinsicHeight().toFloat() / d.getIntrinsicWidth()).toDouble()
            ) as Int
            this.setMeasuredDimension(width, height)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
