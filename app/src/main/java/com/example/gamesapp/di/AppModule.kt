package com.example.gamesapp.di

import com.example.gamesapp.domain.usecase.UseCase
import com.example.gamesapp.domain.usecase.UseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(useCaseImpl: UseCaseImpl) : UseCase
}