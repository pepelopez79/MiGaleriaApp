package com.jlopsal.migaleria.ui.screens.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jlopsal.migaleria.model.getMedia
import com.jlopsal.migaleria.ui.screens.shared.ArrowBackIcon
import com.jlopsal.migaleria.ui.screens.shared.Thumb
import com.jlopsal.migaleria.ui.theme.Gray
import com.jlopsal.migaleria.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title, color = White) },
                navigationIcon = { ArrowBackIcon(onUpClick) },
                backgroundColor = Gray
            )
        },
        backgroundColor = Color.DarkGray
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Thumb(
                mediaItem = mediaItem
            )
            Text(
                text = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(mediaItem.date),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End),
                color = Color.White
            )
            Text(
                text = mediaItem.description,
                fontSize = 18.sp,
                modifier = Modifier.padding(22.dp),
                color = White
            )
        }
    }
}