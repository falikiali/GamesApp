package com.example.gamesapp.data.remote

import com.example.gamesapp.data.remote.responses.ResponseGenres
import com.example.gamesapp.data.remote.network.ApiService
import com.example.gamesapp.data.remote.responses.ResponseGames
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : RemoteDataSource {
    override suspend fun getGenres(): ResponseGenres = apiService.getGenres()
    override suspend fun getGames(): ResponseGames = apiService.getGames()
    override suspend fun searchGames(keyword: String): ResponseGames = apiService.searchGames(keyword)
}