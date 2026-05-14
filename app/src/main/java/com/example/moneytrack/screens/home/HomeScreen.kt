package com.example.moneytrack.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moneytrack.ui.theme.MoneyTrackTheme

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp, vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0F172A)
fun HomeScreenPreview() {
    val navController = rememberNavController()
    MoneyTrackTheme {
        HomeScreen(navController)
    }
}