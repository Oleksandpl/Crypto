package com.example.crypto.domain.use_case

import com.example.crypto.common.Resource
import com.example.crypto.data.remote.dto.details.toCoinDetails
import com.example.crypto.domain.model.details.CoinDetails
import com.example.crypto.domain.repository.CoinpapricaRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinpapricaRemote
) {
    operator fun invoke(id: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetails = repository.getCoinOrderById(id).toCoinDetails()
            emit(Resource.Success(coinDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}