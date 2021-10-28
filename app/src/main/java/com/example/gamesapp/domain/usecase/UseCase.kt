package com.example.gamesapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.utils.ResultState

interface UseCase {
    fun getGenre() : LiveData<ResultState<List<DataGenre>>>
}