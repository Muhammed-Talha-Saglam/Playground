package com.tokeninc.playground

import android.util.Log
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    val flavorName = "MOBILE FLAVOR"

    init {
        Log.d("FLAVOR_NAME", flavorName)
    }
}