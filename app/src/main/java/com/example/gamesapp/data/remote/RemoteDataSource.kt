package com.example.gamesapp.data.remote

import com.example.gamesapp.data.remote.responses.ResponseGames
import com.example.gamesapp.data.remote.responses.ResponseGenres

interface RemoteDataSource {
    suspend fun getGenres(): ResponseGenres
    suspend fun getGames(): ResponseGames
    suspend fun searchGames(keyword: String): ResponseGames
}