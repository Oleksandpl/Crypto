package com.example.crypto.presentation.navigation

sealed class Screen(val route: String) {
    data object Homepage : Screen("homepage")
    data object Details : Screen("details")
}