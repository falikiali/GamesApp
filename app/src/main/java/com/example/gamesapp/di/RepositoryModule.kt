package com.example.gamesapp.di

import com.example.gamesapp.data.RepositoryImpl
import com.example.gamesapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(repositoryImpl: RepositoryImpl) : Repository
}