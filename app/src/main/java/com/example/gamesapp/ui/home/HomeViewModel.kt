package com.example.gamesapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamesapp.domain.model.DataGame
import com.example.gamesapp.domain.model.DataGenre
import com.example.gamesapp.domain.usecase.UseCase
import com.example.gamesapp.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

interface HomeViewModelContract {
    fun getGames()
}

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: UseCase) : ViewModel(), HomeViewModelContract {
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _resultGames = MutableLiveData<List<DataGame>>()
    val resultGames: LiveData<List<DataGame>> get() = _resultGames

    init {
        getGames()
    }

    override fun getGames() {
        viewModelScope.launch {
            useCase.getGames().collect { data ->
                when(data) {
                    is ResultState.Success -> _resultGames.postValue(data.data)
                    is ResultState.Error -> _error.postValue(data.error)
                }
            }
        }
    }


}