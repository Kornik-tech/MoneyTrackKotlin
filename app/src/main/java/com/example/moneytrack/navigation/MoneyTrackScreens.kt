package com.example.moneytrack.navigation

enum class MoneyTrackScreens {
    LoginScreen;

    companion object {
        fun fromRoute(route: String?): MoneyTrackScreens = when(route?.substringBefore("/")) {
            LoginScreen.name -> LoginScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}