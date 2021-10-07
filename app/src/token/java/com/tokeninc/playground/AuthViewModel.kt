package com.tokeninc.playground

import android.os.CountDownTimer
import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    val flavorName = "TOKEN FLAVOR"

    init {
        Log.d("FLAVOR_NAME", flavorName)
    }
}