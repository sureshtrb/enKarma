package com.karma.sureshtrb.enKarma

import android.content.Context
import android.util.AttributeSet
import android.view.View.MeasureSpec
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

class DynamicImageVieww @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = drawable
        if (d != null) {
            // Use ceil to avoid thin vertical gaps along edges
            val width = MeasureSpec.getSize(widthMeasureSpec)
            val height = ceil(width * d.intrinsicHeight.toFloat() / d.intrinsicWidth).toInt()
            setMeasuredDimension(width, height)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
