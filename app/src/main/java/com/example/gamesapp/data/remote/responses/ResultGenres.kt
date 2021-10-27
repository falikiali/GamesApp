package com.example.gamesapp.data.remote.responses

data class ResultGenres(
    val games: List<GameByGenre>,
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val name: String,
    val slug: String
)