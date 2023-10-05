package com.example.crypto.di

import com.example.crypto.domain.repository.CoinpapricaRemote
import com.example.crypto.domain.use_case.GetCoinDetailsUseCase
import com.example.crypto.domain.use_case.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideCoinDetailsUseCase(repository: CoinpapricaRemote): GetCoinDetailsUseCase {
        return GetCoinDetailsUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideCoinsUseCase(repository: CoinpapricaRemote): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }
}