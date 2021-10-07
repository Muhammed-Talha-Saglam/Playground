package com.tokeninc.playground

import android.os.CountDownTimer
import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData

class AuthViewModel: BaseViewModel() {



    val userEmail = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    private val _passwordCounter = MutableLiveData(0)

    fun emailInputListener(email: Editable) {
        userEmail.value = email.toString()
    }

    fun passwordInputListener(password: Editable) {
        userPassword.value = password.toString()
    }

    fun incrementCounter() {

        _passwordCounter.value = _passwordCounter.value?.plus(1)
        if (_passwordCounter.value == 1) {
            startTimer()
        } else if (_passwordCounter.value == 5) {
        }
    }


    fun resetCounter() {
        _passwordCounter.value = 0
    }

    fun startTimer() {
        val timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("onTick", _passwordCounter.value.toString())
            }
            override fun onFinish() {
                resetCounter()
            }
        }
        timer.start()
    }


}