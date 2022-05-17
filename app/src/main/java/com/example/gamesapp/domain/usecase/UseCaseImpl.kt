package com.example.gamesapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.repository.Repository
import com.example.gamesapp.utils.ResultState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val repository: Repository) : UseCase {
    override suspend fun getGenres(): Flow<ResultState<List<DataGenre>>> = repository.getGenres()
    override suspend fun getGames(): Flow<ResultState<List<DataGame>>> = repository.getGames()
    override suspend fun searchGames(keyword: String): Flow<ResultState<List<DataGame>>> = repository.searchGames(keyword)
}