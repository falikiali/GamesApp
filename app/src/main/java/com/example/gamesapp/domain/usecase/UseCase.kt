package com.example.gamesapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.utils.ResultState
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun getGenres(): Flow<ResultState<List<DataGenre>>>
    suspend fun getGames(): Flow<ResultState<List<DataGame>>>
    suspend fun searchGames(keyword: String): Flow<ResultState<List<DataGame>>>
}