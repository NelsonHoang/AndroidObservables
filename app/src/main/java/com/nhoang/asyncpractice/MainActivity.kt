package com.nhoang.asyncpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.nhoang.asyncpractice.ui.HomeScreen
import com.nhoang.asyncpractice.ui.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel : HomeViewModel by viewModels()
        setContent {
            HomeScreen(homeViewModel)
        }
    }
}