package com.example.crypto.presentation.ui.screens.detailsScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Resource
import com.example.crypto.di.GlobalState
import com.example.crypto.domain.use_case.GetCoinDetailsUseCase
import com.example.crypto.presentation.ui.screens.homepageScreen.CoinsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsUseCase: GetCoinDetailsUseCase,
    private val detailsCoinState: GlobalState
) : ViewModel() {
    private val _coinDetailsState: MutableState<DetailsState> = mutableStateOf(DetailsState())
    val coinDetailsState: State<DetailsState> = _coinDetailsState

    init {
        getDetails(detailsCoinState.detailsIdState.value)
    }

    private fun getDetails(id: String) {
        detailsUseCase.invoke(id).onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { data ->
                        _coinDetailsState.value = DetailsState(
                            coinDetails = data
                        )
                    }
                }

                is Resource.Loading -> {
                    _coinDetailsState.value = DetailsState(isLoading = true)
                }

                is Resource.Error -> {
                    _coinDetailsState.value =
                        DetailsState(error = resource.message ?: "An unexpected message occurred")
                }
            }

        }.launchIn(viewModelScope)
    }
}