package com.nhoang.asyncpractice.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _liveDataText = MutableLiveData("Hello World")
    val liveDataText = _liveDataText

    private val _stateFlowText = MutableStateFlow("Hello World")
    val stateFlowText = _stateFlowText.asStateFlow()

    private val _sharedFlowText = MutableSharedFlow<String>()
    val sharedFlowText =  _sharedFlowText.asSharedFlow()

    fun triggerLiveData() {
        _liveDataText.value = "Live Data"
    }

    fun triggerStateFlow() {
        _stateFlowText.value = "State Flow"
    }

    suspend fun triggerSharedFlow() {
        _sharedFlowText.emit("Shared Flow")
    }
}