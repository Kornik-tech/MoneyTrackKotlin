package com.example.moneytrack.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector,
    disabled: Boolean = false
    ){
    Button(modifier = modifier
        .fillMaxWidth().background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(15.dp)),
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        enabled = disabled
    ) {
        Text(text = text, color = Color.White, fontSize = 18.sp)
        Icon(
            imageVector = leadingIcon,
            contentDescription = null,
            tint = Color.White
        )
    }
}
