package com.nhoang.asyncpractice.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _liveDataText = MutableLiveData("Hello World")
    val liveDataText = _liveDataText

    fun triggerLiveData() {
        _liveDataText.value = "Live Data"
    }

}