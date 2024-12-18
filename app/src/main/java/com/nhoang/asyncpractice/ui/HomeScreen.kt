package com.nhoang.asyncpractice.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val liveDataText by homeViewModel.liveDataText.observeAsState()
    val stateFlowText by homeViewModel.stateFlowText.collectAsState()
    val sharedFlowText by homeViewModel.sharedFlowText.collectAsState("Hello World")

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = liveDataText ?: "",
            fontSize = 24.sp
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            onClick = {
                homeViewModel.triggerLiveData()
            },
            border = BorderStroke(2.dp, Color.LightGray),
            shape = RoundedCornerShape(50)
        ) {
            Text("Live Data")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stateFlowText,
            fontSize = 24.sp
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            onClick = {
                homeViewModel.triggerStateFlow()
            },
            border = BorderStroke(2.dp, Color.LightGray),
            shape = RoundedCornerShape(50)
        ) {
            Text("State Flow")
        }
        Text(
            text = sharedFlowText,
            fontSize = 24.sp
        )
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            onClick = {
                homeViewModel.viewModelScope.launch {
                    homeViewModel.triggerSharedFlow()
                }
            },
            border = BorderStroke(2.dp, Color.LightGray),
            shape = RoundedCornerShape(50)
        ) {
            Text("Shared Flow")
        }
    }
}