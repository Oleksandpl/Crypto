package com.example.crypto.presentation.ui.screens.detailsScreen

import com.example.crypto.domain.model.details.CoinDetails

data class DetailsState(
    val coinDetails: CoinDetails? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)