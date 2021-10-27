package com.example.gamesapp.data

import androidx.lifecycle.LiveData
import com.example.gamesapp.data.remote.RemoteDataSource
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.repository.Repository

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getGenres(): LiveData<List<DataGenre>> {
        TODO("Not yet implemented")
    }
}