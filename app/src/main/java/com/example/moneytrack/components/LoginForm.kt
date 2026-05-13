package com.example.moneytrack.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moneytrack.widgets.CustomButton
import com.example.moneytrack.widgets.CustomTextField

@Composable
fun LoginForm() {
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        Text(text = "EMAIL", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(horizontal = 3.dp, vertical = 9.dp))
        CustomTextField(
            value = emailState.value,
            onValueChange = {emailState.value = it},
            placeholder = "name@example.com",
            leadingIcon = Icons.Outlined.Person
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "PASSWORD", style = MaterialTheme.typography.labelSmall, modifier = Modifier.padding(horizontal = 3.dp, vertical = 9.dp))
        CustomTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            placeholder = "••••••••",
            leadingIcon = Icons.Default.Lock
        )

        Spacer(modifier = Modifier.height(30.dp))

        CustomButton(
            text = "Log in",
            onClick = {},
            leadingIcon = Icons.AutoMirrored.Filled.KeyboardArrowRight
        )
    }
}
