package com.example.crypto.presentation.ui.screens.homepageScreen

sealed class HomepageObserver {
    data object OnItemClick : HomepageObserver()
}