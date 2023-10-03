package com.example.crypto.domain.repository

import com.example.crypto.data.remote.dto.CoinDto

interface CoinpapricaRemote {

    suspend fun getCoins(): List<CoinDto>

}