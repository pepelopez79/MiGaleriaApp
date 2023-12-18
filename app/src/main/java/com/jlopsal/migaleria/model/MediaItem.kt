package com.jlopsal.migaleria.model

import com.jlopsal.migaleria.model.MediaItem.Type
import java.util.Calendar
import java.util.Date

data class MediaItem(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val type: Type,
    val date: Date
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMedia() = (1..20).map {
    val mediaType = if (it % 3 == 0) Type.VIDEO else Type.PHOTO
    val mediaTitle = if (mediaType == Type.VIDEO) "Video $it" else "Imagen $it"
    val mediaDescription = when (mediaType) {
        Type.PHOTO -> "Esta es la descripción de la imagen $it. Se trata de una representación visual que captura un momento de la realidad, destacando la composición, la iluminación y los colores de manera impactante."
        Type.VIDEO -> "Esta es la descripción del video $it. Se trata de un video en movimiento que muestra una escena de la realidad en acción. Experimenta la narrativa visual a través de las imágenes en movimiento y el sonido cautivador."
    }
    val mediaDate = generateRandomDate()

    MediaItem(
        id = it,
        title = mediaTitle,
        description = mediaDescription,
        image = "https://picsum.photos/400/400?cars&$it",
        type = mediaType,
        date = mediaDate
    )
}

private fun generateRandomDate(): Date {
    val calendar = Calendar.getInstance()
    val randomYear = (2000..2022).random()
    val randomMonth = (1..12).random()
    val randomDay = (1..31).random()
    val randomHour = (0..23).random()
    val randomMinute = (0..59).random()

    calendar.set(randomYear, randomMonth, randomDay, randomHour, randomMinute)

    return calendar.time
}