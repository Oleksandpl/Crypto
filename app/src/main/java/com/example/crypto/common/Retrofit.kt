package com.example.crypto.common

import com.example.crypto.data.remote.CoinpaprikaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(Client.okHttpClient)
            .build()
    }

    val coinpaprikaApi: CoinpaprikaApi by lazy {
        retrofit.create(CoinpaprikaApi::class.java)
    }
}

private object Client {
    private val interceptor by lazy {
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    val okHttpClient by lazy { OkHttpClient.Builder().addInterceptor(interceptor).build() }
}