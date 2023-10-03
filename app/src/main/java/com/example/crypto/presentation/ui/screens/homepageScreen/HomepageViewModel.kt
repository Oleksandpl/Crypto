package com.example.crypto.presentation.ui.screens.homepageScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.crypto.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val coinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _coinsState: MutableState<CoinsState> = mutableStateOf(CoinsState())
    val coinsState: State<CoinsState> = _coinsState

    fun observer(onClick: HomepageObserver) {
        when (onClick) {
            HomepageObserver.OnItemClick -> {
            }
        }
    }
}