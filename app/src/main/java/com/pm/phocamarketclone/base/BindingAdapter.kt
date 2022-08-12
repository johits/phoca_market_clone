package com.pm.phocamarketclone.base

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener


@BindingAdapter(value = ["longToStringText"])
fun longToStringText(view: EditText, text: Long) {
    view.setText(text.toString())
}

@BindingAdapter("textAttrChanged")
fun setTextWatcher(view: TextView, listener: InverseBindingListener?) {
    if (listener != null) {
        view.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                listener.onChange()
            }
        })
    }
}

    @InverseBindingAdapter(attribute = "longToStringText", event = "textAttrChanged")
    fun getText(view: EditText): Long {
        return view.text.toString().toLong()
    }
