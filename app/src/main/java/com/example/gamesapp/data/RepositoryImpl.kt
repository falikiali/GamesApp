package com.example.gamesapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamesapp.data.remote.RemoteDataSource
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.repository.Repository
import com.example.gamesapp.utils.DataMapper
import com.example.gamesapp.utils.ResultState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getGenres(): LiveData<ResultState<List<DataGenre>>> {
        val result = MutableLiveData<ResultState<List<DataGenre>>>()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getGenres()
                if (response.results.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    result.postValue(ResultState.Success(DataMapper.mapGenreResponseToDomain(response.results)))
                }
            } catch (ex: IOException) {
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }

        return result
    }

    override fun getGames(): LiveData<ResultState<List<DataGame>>> {
        val result =  MutableLiveData<ResultState<List<DataGame>>>()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.getGames()
                if (response.results.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    result.postValue(ResultState.Success(DataMapper.mapGameResponseToDomain(response.results)))
                }
            } catch (ex: IOException) {
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }

        return result
    }
}