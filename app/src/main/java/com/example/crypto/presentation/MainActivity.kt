package com.example.crypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crypto.presentation.ui.screens.homepageScreen.HomepageObserver
import com.example.crypto.presentation.ui.screens.homepageScreen.HomepageScreen
import com.example.crypto.presentation.ui.screens.homepageScreen.HomepageViewModel
import com.example.crypto.presentation.ui.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                val viewModel = hiltViewModel<HomepageViewModel>()
                HomepageScreen(viewModel.coinsState){}
            }
        }
    }
}