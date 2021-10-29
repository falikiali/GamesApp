package com.example.gamesapp.domain.model

data class DataGame(
    val id: Int,
    val name: String,
    val released: String,
    val background_image: String,
    val rating: Double,
    val short_screenshots: List<DataScreenshotByGame>,
    val genres: List<DataGenreByGame>
)
