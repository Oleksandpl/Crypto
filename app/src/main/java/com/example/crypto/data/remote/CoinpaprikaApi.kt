package com.example.crypto.data.remote

import com.example.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinpaprikaApi {

    @Headers("accept: application/json")
    @GET("coins")
    suspend fun getCoins(): List<CoinDto>

}