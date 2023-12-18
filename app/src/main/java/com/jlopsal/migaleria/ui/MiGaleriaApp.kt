package com.jlopsal.migaleria.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.jlopsal.migaleria.ui.theme.MiGaleriaTheme

@Composable
fun MiGaleriaApp(content: @Composable () -> Unit) {
    MiGaleriaTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}