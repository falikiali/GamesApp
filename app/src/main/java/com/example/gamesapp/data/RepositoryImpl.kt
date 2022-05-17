package com.example.gamesapp.data

import com.example.gamesapp.data.remote.RemoteDataSource
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.repository.Repository
import com.example.gamesapp.utils.DataMapper
import com.example.gamesapp.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun getGenres(): Flow<ResultState<List<DataGenre>>> {
        return flow {
            try {
                val response = remoteDataSource.getGenres()
                if (response.results.isEmpty()) {
                    emit(ResultState.Empty)
                } else {
                    val genreResponses = response.results
                    val dataMaped = genreResponses?.let { DataMapper.mapGenreResponseToDomain(it) }
                    emit(ResultState.Success(dataMaped))
                }
            } catch (e: Exception) {
                emit(ResultState.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

        /*val result = MutableLiveData<ResultState<List<DataGenre>>>()

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

        return result*/
    }

    override suspend fun getGames(): Flow<ResultState<List<DataGame>>> {
        return flow {
            try {
                val response = remoteDataSource.getGames()
                if (response.results.isEmpty()) {
                    emit(ResultState.Empty)
                } else {
                    val gameResponses = response.results
                    val dataMaped = gameResponses?.let { DataMapper.mapGameResponseToDomain(it) }
                    emit(ResultState.Success(dataMaped))
                }
            } catch (e: Exception) {
                emit(ResultState.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

        /*val result =  MutableLiveData<ResultState<List<DataGame>>>()

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

        return result*/
    }

    override suspend fun searchGames(keyword: String): Flow<ResultState<List<DataGame>>> {
        return flow {
            try {
                val response = remoteDataSource.searchGames(keyword)
                if (response.results.isEmpty()) {
                    emit(ResultState.Empty)
                } else {
                    val searchGameResponses = response.results
                    val dataMaped = searchGameResponses?.let { DataMapper.mapGameResponseToDomain(it) }
                    emit(ResultState.Success(dataMaped))
                }
            } catch (e: Exception) {
                emit(ResultState.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)

        /*val result =  MutableLiveData<ResultState<List<DataGame>>>()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteDataSource.searchGames(keyword)
                if (response.results.isEmpty()) {
                    result.postValue(ResultState.Empty)
                } else {
                    result.postValue(ResultState.Success(DataMapper.mapGameResponseToDomain(response.results)))
                }
            } catch (ex: IOException) {
                result.postValue(ResultState.Error(ex.message.toString()))
            }
        }

        return result*/
    }
}