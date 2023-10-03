package com.example.crypto.di

import com.example.crypto.data.remote.CoinpaprikaApi
import com.example.crypto.data.repository.CoinpapricaRemoteImpl
import com.example.crypto.domain.repository.CoinpapricaRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinpapricaRemote(api: CoinpaprikaApi): CoinpapricaRemote {
        return CoinpapricaRemoteImpl(api)
    }
}