package com.example.crypto.data.repository

import com.example.crypto.data.remote.CoinpaprikaApi
import com.example.crypto.data.remote.dto.CoinDto
import com.example.crypto.domain.repository.CoinpapricaRemote
import javax.inject.Inject

class CoinpapricaRemoteImpl @Inject constructor(
    private val api: CoinpaprikaApi
) : CoinpapricaRemote {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

}