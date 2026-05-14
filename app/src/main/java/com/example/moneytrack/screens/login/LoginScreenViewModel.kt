package com.example.moneytrack.screens.login

import androidx.lifecycle.ViewModel
import com.example.moneytrack.data.LoginState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun signInWithEmailAndPassword(email: String, password: String, onSuccess: () -> Unit) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _uiState.update { it.copy(error = "Invalid email format.") }
            return
        }

        _uiState.update { it.copy(isLoading = true) }

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _uiState.update { it.copy(isLoading = false) }
                    onSuccess()
                } else {
                    _uiState.update { it.copy(error = mapFirebaseError(task.exception), isLoading = false) }
                }
            }
    }
}

private fun mapFirebaseError(e: Exception?): String {
    return when(e) {
        is FirebaseAuthInvalidCredentialsException -> "Invalid login credentials."
        is FirebaseAuthInvalidUserException -> "User not exists."
        else -> "Unexpected error happen try again."

    }
}