package com.example.gamesapp.domain.model

data class DataGenre(
    val games: List<DataGameByGenre>,
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String
)
