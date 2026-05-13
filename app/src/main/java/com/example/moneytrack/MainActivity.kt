package com.example.moneytrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moneytrack.navigation.MoneyTrackNavigation
import com.example.moneytrack.ui.theme.MoneyTrackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoneyTrack()
        }
    }
}

@Composable
fun MoneyTrack() {
    MoneyTrackTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
            MoneyTrackNavigation(innerPadding)
        }
    }
}