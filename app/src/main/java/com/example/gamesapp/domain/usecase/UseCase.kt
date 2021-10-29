package com.example.gamesapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.utils.ResultState

interface UseCase {
    fun getGenres(): LiveData<ResultState<List<DataGenre>>>
    fun getGames(): LiveData<ResultState<List<DataGame>>>
    fun searchGames(keyword: String): LiveData<ResultState<List<DataGame>>>
}