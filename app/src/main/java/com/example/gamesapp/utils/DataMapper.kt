package com.example.gamesapp.utils

import com.example.gamesapp.data.remote.responses.Genre
import com.example.gamesapp.data.remote.responses.ResultGames
import com.example.gamesapp.data.remote.responses.ResultGenres
import com.example.gamesapp.data.remote.responses.ShortScreenshot
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.model.DataGenreByGame
import com.example.gamesapp.domain.model.DataScreenshotByGame

object DataMapper {
    fun mapGenreResponseToDomain(input: List<ResultGenres>): List<DataGenre> =
        input.map { data ->
            DataGenre(
                data.games_count,
                data.id,
                data.image_background,
                data.name,
                data.slug
            )
        }

    fun mapGameResponseToDomain(input: List<ResultGames>): List<DataGame> =
        input.map { data ->
            DataGame(
                data.id,
                data.name,
                data.released,
                data.background_image,
                data.rating,
                mapShortScreenshotToDomain(data.short_screenshots),
                mapGenreByGameToDomain(data.genres)
            )
        }

    private fun mapShortScreenshotToDomain(input: List<ShortScreenshot>): List<DataScreenshotByGame> =
        input.map {
            DataScreenshotByGame(
                it.id,
                it.image
            )
        }

    private fun mapGenreByGameToDomain(input: List<Genre>): List<DataGenreByGame> =
        input.map {
            DataGenreByGame(
                it.games_count,
                it.id,
                it.image_background,
                it.name,
                it.slug,
            )
        }
}