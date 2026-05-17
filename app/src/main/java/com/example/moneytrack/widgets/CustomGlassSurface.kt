package com.example.moneytrack.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomGlassSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(15.dp),
    background: Color = Color(0xFF111827),
    elevation: Dp = 10.dp,
    borderColor: Color = Color(0xFF1F2937),
    content: @Composable () -> Unit,
    ) {
    Surface(
        modifier = modifier.border(width = 1.dp, color = borderColor, shape = shape),
        shape = shape,
        color = background,
        tonalElevation = elevation,
    ) {
        content()
    }
}