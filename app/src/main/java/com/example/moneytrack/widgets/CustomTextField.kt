package com.example.moneytrack.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    isLogin: Boolean = false,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: ImageVector,
    autoFillType: ContentType? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .semantics{
                if (autoFillType != null) {
                    contentDescription = placeholder
                    contentType = autoFillType
                }
            },
        placeholder = { Text(text = placeholder) },
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        singleLine = true,
        shape = RoundedCornerShape(15.dp),
        colors = if (isLogin) OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color(0xFF374151),
        ) else OutlinedTextFieldDefaults.colors()
    )
}