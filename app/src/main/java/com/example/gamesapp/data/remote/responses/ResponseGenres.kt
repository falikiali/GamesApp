package com.example.gamesapp.data.remote.responses

data class ResponseGenres(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ResultGenres>
)