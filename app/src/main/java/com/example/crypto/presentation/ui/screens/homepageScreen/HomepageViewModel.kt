package com.example.crypto.presentation.ui.screens.homepageScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Resource
import com.example.crypto.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val coinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _coinsState: MutableState<CoinsState> = mutableStateOf(CoinsState())
    val coinsState: State<CoinsState> = _coinsState

    init {
        getCoins()
    }

    fun observer(onClick: HomepageObserver) {
        when (onClick) {
            HomepageObserver.OnItemClick -> {
            }
        }
    }

    private fun getCoins() {
        coinsUseCase.invoke().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    resource.data?.let { list ->
                        _coinsState.value = CoinsState(coins = list)
                    }
                }

                is Resource.Loading -> {
                    _coinsState.value = CoinsState(isLoading = true)
                }

                is Resource.Error -> {
                    _coinsState.value =
                        CoinsState(error = resource.message ?: "An unexpected message occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}