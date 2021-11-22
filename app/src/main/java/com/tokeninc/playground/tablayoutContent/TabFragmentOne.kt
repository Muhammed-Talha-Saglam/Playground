package com.tokeninc.playground.tablayoutContent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.format.Formatter
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.tokeninc.playground.R

class TabFragmentOne : Fragment(R.layout.fragment_tab_one) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val et = view.findViewById<EditText>(R.id.et)
        val etNumber = view.findViewById<EditText>(R.id.et_number)

        et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                et.removeTextChangedListener(this)

                if (s.toString().length < 3) {
                    if (s.toString().toIntOrNull() == null) {
                        et.setText("")
                        et.addTextChangedListener(this)
                        return
                    }
                }
                if (s.toString().length == 3 && s.toString().last().isDigit()) {
                    et.setText(s.toString().dropLast(1))
                    et.setSelection(et.text.length)
                    et.addTextChangedListener(this)
                    return
                }


                if (s.toString().length < 13) {
                    et.setText(formatPlateName(s.toString()))
                    et.setSelection(et.text.length)
                } else {
                    et.setText(s.toString().dropLast(1))
                    et.setSelection(et.text.length)
                }
                et.addTextChangedListener(this)
            }

        })


        // limit TCKN and VKN to 11 digit.
        etNumber.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                    et.removeTextChangedListener(this)

                    if (s.toString().length == 12) {
                        etNumber.setText(s.toString().dropLast(1))
                        etNumber.setSelection(etNumber.text.length)
                    }

                    et.addTextChangedListener(this)

                }

            })

    }


    private fun formatPlateName(plate: String): String {
        val firstLetterIndex = plate.indexOfFirst {
            it.isLetter()
        }

        val lastLetterIndex = plate.indexOfLast {
            it.isLetter()
        }

        val sBuilder = StringBuilder(plate)

        val spaceCount = plate.count {
            it.isWhitespace()
        }

        if (spaceCount == 0 && firstLetterIndex > 0) {
            sBuilder.insert(firstLetterIndex, " ")
        }

        if (spaceCount == 1 && plate.last().isDigit()) {
            sBuilder.insert(lastLetterIndex + 1, " ")
        }

        Log.d("formatPlateName end", sBuilder.toString())
        return sBuilder.toString()
    }
}