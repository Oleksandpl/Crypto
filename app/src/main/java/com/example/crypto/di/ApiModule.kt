package com.example.crypto.di

import com.example.crypto.common.RetrofitService
import com.example.crypto.data.remote.CoinpaprikaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideCoinpapricaApi():CoinpaprikaApi{
        return RetrofitService.coinpaprikaApi
    }

}