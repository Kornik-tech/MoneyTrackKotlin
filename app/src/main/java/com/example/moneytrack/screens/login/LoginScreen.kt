package com.example.moneytrack.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.moneytrack.R
import com.example.moneytrack.components.LoginForm
import com.example.moneytrack.data.LoginState
import com.example.moneytrack.navigation.MoneyTrackScreens
import com.example.moneytrack.ui.theme.MoneyTrackTheme

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginScreenViewModel = hiltViewModel()) {
    val apiState = viewModel.uiState.collectAsState()

    LoginScreenContent(
        apiState = apiState.value,
        onLogin = { email, password ->
            viewModel.signInWithEmailAndPassword(email = email, password = password) {
                navController.navigate(MoneyTrackScreens.HomeScreen.name) {
                    popUpTo(MoneyTrackScreens.LoginScreen.name) {
                        inclusive = true
                    }
                }
            }
        }
    )
}

@Composable
fun LoginScreenContent(
    apiState: LoginState,
    onLogin: (String, String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier
        .padding(vertical = 80.dp, horizontal = 25.dp)
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                focusManager.clearFocus()
            })
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Heading()

        LoginForm { email, password ->
            onLogin(email, password)
        }

        if (apiState.error != null) {
            Text(
                text = apiState.error,
                color = Color.Red,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        if (apiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}

@Composable
private fun Heading() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(90.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF203048), Color(0xFF16233C)),
                        start = Offset.Zero,
                        end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    ),
                    shape = RoundedCornerShape(20.dp)
                ),
            color = Color.Transparent
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money_bag),
                    contentDescription = "Money Icon",
                    tint = Color(0xFFFFD700),
                    modifier = Modifier.size(45.dp)
                )
            }
        }
        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            modifier = Modifier
                .padding(12.dp),
            text = "Log in to manage your wealth",
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF0F172A)
fun LoginScreenPreview() {
    MoneyTrackTheme {
        LoginScreenContent(
            apiState = LoginState(),
            onLogin = { _, _ -> }
        )
    }
}
