package com.example.bloodpressure.widgets.customview

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.bloodpressure.callBack.ListenerMyEditText

class MyEditText(context: Context?, attributeSet: AttributeSet?) : AppCompatEditText(
    context!!, attributeSet
) {
    private lateinit var callBack: ListenerMyEditText

    init {
        LinkedHashMap<Any?, Any?>()
    }

    override fun onTextContextMenuItem(i: Int): Boolean {
        if (i == 16908322) {
            callBack.onChangeMyEditText()
        }
        return super.onTextContextMenuItem(i)
    }

    fun setPasteListener(callBack: ListenerMyEditText) {
        this.callBack = callBack
    }
}