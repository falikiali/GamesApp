package com.example.gamesapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.gamesapp.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCase: UseCase) : ViewModel() {
    val games = useCase.getGames()
}