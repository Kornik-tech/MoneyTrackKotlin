package com.example.moneytrack.navigation

enum class MoneyTrackScreens {
    LoginScreen,
    HomeScreen,
    NotificationsScreen; // TODO

    companion object {
        fun fromRoute(route: String?): MoneyTrackScreens = when(route?.substringBefore("/")) {
            LoginScreen.name -> LoginScreen
            HomeScreen.name -> HomeScreen
            NotificationsScreen.name -> NotificationsScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}