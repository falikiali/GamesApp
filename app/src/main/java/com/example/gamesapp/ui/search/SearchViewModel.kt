package com.example.gamesapp.ui.search

import androidx.lifecycle.ViewModel
import com.example.gamesapp.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun searchGames(keyword: String) = useCase.searchGames(keyword)
}