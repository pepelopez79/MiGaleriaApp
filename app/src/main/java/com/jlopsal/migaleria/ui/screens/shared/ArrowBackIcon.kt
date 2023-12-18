package com.jlopsal.migaleria.ui.screens.shared

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import com.jlopsal.migaleria.ui.theme.White

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(
        onClick = onUpClick
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            tint = White
        )
    }
}