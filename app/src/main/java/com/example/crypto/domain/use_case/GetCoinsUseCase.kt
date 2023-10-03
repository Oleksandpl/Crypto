package com.example.crypto.domain.use_case

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.toCoin
import com.example.crypto.domain.model.Coin
import com.example.crypto.domain.repository.CoinpapricaRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinpapricaRemote
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val result = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(result))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected message occurred"))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected message occurred"))
        }
    }
}