package com.example.gamesapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.utils.ResultState

interface Repository {
    fun getGenres(): LiveData<ResultState<List<DataGenre>>>
}