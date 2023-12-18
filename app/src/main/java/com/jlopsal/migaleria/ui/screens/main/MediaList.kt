package com.jlopsal.migaleria.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jlopsal.migaleria.R
import com.jlopsal.migaleria.model.MediaItem
import com.jlopsal.migaleria.model.getMedia
import com.jlopsal.migaleria.ui.MiGaleriaApp
import com.jlopsal.migaleria.ui.screens.shared.Thumb
import java.util.Date

@ExperimentalFoundationApi
@Composable
fun MediaList(
    onClick: (MediaItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
            .background(Color.DarkGray)
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                onClick = { onClick(it) },
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() },
    ) {
        Column {
            Thumb(mediaItem)
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(R.dimen.padding_xsmall))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview
@Composable
fun MediaListItemPreview() {
    MiGaleriaApp {
        val mediaItem = MediaItem(1, "Item 1", "Desripción 1", "https://picsum.photos/400/400?cars&1", MediaItem.Type.VIDEO, Date())
        MediaListItem(mediaItem = mediaItem, onClick = {})
    }
}