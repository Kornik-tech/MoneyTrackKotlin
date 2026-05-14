package com.example.moneytrack.data

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
)
