package com.example.gamesapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.repository.Repository
import com.example.gamesapp.utils.ResultState
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val repository: Repository) : UseCase {
    override fun getGenre(): LiveData<ResultState<List<DataGenre>>> = repository.getGenres()
}