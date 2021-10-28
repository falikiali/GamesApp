package com.example.gamesapp.utils

import com.example.gamesapp.data.remote.responses.GameByGenre
import com.example.gamesapp.data.remote.responses.ResultGenres
import com.example.gamesapp.domain.model.DataGameByGenre
import com.example.gamesapp.domain.model.DataGenre

object DataMapper {
    fun mapGenreResponseToDomain(input: List<ResultGenres>) : List<DataGenre> =
        input.map { data ->
            DataGenre(
                mapGameByGenreResponseToDomain(data.games),
                data.games_count,
                data.id,
                data.image_background,
                data.name,
                data.slug
            )
        }

    fun mapGameByGenreResponseToDomain(input: List<GameByGenre>) : List<DataGameByGenre> =
        input.map { data ->
            DataGameByGenre(
                data.added,
                data.id,
                data.name,
                data.slug
            )
        }
}