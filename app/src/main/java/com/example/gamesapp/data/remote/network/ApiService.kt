package com.example.gamesapp.data.remote.network

import com.example.gamesapp.BuildConfig.API_KEY
import com.example.gamesapp.data.remote.responses.ResponseGames
import com.example.gamesapp.data.remote.responses.ResponseGenres
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("genres")
    suspend fun getGenres(@Query("key") key: String = API_KEY) : ResponseGenres

    @GET("games")
    suspend fun getGames(@Query("key") key: String = API_KEY) : ResponseGames

    @GET("games")
    suspend fun searchGames(
        @Query("search") search: String,
        @Query("key") key: String = API_KEY
    ) : ResponseGames
}