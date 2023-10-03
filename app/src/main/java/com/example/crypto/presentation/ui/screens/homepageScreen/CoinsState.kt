package com.example.crypto.presentation.ui.screens.homepageScreen

import com.example.crypto.domain.model.Coin

data class CoinsState(
    val coins: List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
