package com.example.crypto.domain.repository

import com.example.crypto.data.remote.dto.CoinDto
import com.example.crypto.data.remote.dto.details.CoinDetailsDto

interface CoinpapricaRemote {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinOrderById(id: String): CoinDetailsDto

}