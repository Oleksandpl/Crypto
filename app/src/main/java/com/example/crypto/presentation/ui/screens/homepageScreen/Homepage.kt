package com.example.crypto.presentation.ui.screens.homepageScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.crypto.domain.model.Coin
import com.example.crypto.presentation.ui.theme.spacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(state: State<CoinsState>, onClick: (HomepageObserver) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(

            content = {
                stickyHeader {
                    Text(text = "Crypto")
                }
                items(state.value.coins) { item ->
                    CoinItem(coin = item)
                }
            })
    }
}

@Composable
private fun CoinItem(coin: Coin) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .padding(
                    start = MaterialTheme.spacing.large,
                    end = MaterialTheme.spacing.large
                )
                .fillMaxWidth()
               ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "${coin.rank}. ${coin.name}")
            Text(
                text = "active", style = TextStyle(
                    color = if (coin.isActive) Color.Green else Color.Red
                )
            )
        }
    }
}