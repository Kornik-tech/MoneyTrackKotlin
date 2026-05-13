package com.example.moneytrack.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moneytrack.screens.LoginScreen

@Composable
fun MoneyTrackNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = MoneyTrackScreens.LoginScreen.name
    ) {
        composable(MoneyTrackScreens.LoginScreen.name) {
            LoginScreen(navController)
        }
    }
}