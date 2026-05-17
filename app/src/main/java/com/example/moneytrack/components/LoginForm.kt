package com.example.moneytrack.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moneytrack.ui.theme.MoneyTrackTheme
import com.example.moneytrack.widgets.CustomButton
import com.example.moneytrack.widgets.CustomTextField

@Composable
fun LoginForm(
    onDone: (String, String) -> Unit
) {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val showPassword = remember { mutableStateOf(false) }

    val valid = remember(emailState.value, passwordState.value) {
        emailState.value.trim().isNotEmpty() && passwordState.value.trim().isNotEmpty()
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "EMAIL", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(horizontal = 3.dp, vertical = 9.dp))
        CustomTextField(
            value = emailState.value,
            autoFillType = ContentType.EmailAddress,
            onValueChange = {emailState.value = it},
            placeholder = "name@example.com",
            leadingIcon = Icons.Outlined.Person
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "PASSWORD", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(horizontal = 3.dp, vertical = 9.dp))
        CustomTextField(
            value = passwordState.value,
            autoFillType = ContentType.Password,
            onValueChange = { passwordState.value = it },
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Lock,
            trailingIcon = {
                Icon(if (showPassword.value) {
                    Icons.Default.Visibility
                } else {
                    Icons.Default.VisibilityOff
                },
                    contentDescription = "Show password",
                    modifier = Modifier.clickable {
                        showPassword.value = !showPassword.value
                    }
                )
            },
            visualTransformation = if (!showPassword.value) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        CustomButton(
            text = "Log in",
            disabled = valid,
            onClick = {onDone(emailState.value, passwordState.value)},
            leadingIcon = Icons.AutoMirrored.Filled.KeyboardArrowRight
        )
    }
}

@Composable
@Preview
fun LoginFormPreview() {
    MoneyTrackTheme {
        LoginForm {_, _ ->

        }
    }
}