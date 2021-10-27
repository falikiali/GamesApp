package com.example.gamesapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.gamesapp.domain.model.DataGenre

interface Repository {
    fun getGenres(): LiveData<List<DataGenre>>
}