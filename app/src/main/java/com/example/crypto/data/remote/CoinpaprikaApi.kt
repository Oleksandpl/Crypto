package com.example.crypto.data.remote

import com.example.crypto.data.remote.dto.CoinDto
import com.example.crypto.data.remote.dto.details.CoinDetailsDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoinpaprikaApi {

    @Headers("accept: application/json")
    @GET("coins")
    suspend fun getCoins(): List<CoinDto>

    @Headers("accept: application/json")
    @GET("coins/{coin_id}")
    suspend fun getCoinDetailsOrderById(@Path("coin_id") id: String): CoinDetailsDto

}