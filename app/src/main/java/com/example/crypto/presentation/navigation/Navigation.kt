package com.example.crypto.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.crypto.presentation.ui.screens.detailsScreen.DetailsScreen
import com.example.crypto.presentation.ui.screens.detailsScreen.DetailsViewModel
import com.example.crypto.presentation.ui.screens.homepageScreen.HomepageScreen
import com.example.crypto.presentation.ui.screens.homepageScreen.HomepageViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Homepage.route
    ) {
        composable(Screen.Homepage.route) {
            val viewModel = hiltViewModel<HomepageViewModel>()
            HomepageScreen(state = viewModel.coinsState) {
                viewModel.setDetailsCoinState(it.id)
                navController.navigate(Screen.Details.route)
            }
        }
        composable(Screen.Details.route) {
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailsScreen(
                viewModel.coinDetailsState.value
            ){
                navController.popBackStack()
            }
        }
    }
}