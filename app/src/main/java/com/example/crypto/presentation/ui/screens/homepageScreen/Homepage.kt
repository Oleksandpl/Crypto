package com.example.crypto.presentation.ui.screens.homepageScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crypto.domain.model.Coin
import com.example.crypto.presentation.ui.theme.spacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomepageScreen(
    state: State<CoinsState>,
    onClick: (Coin) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
            content = {
                stickyHeader {
                    HeaderCrypto()
                }
                items(
                    state.value.coins, key = {
                        it.id
                    }
                ) { item ->
                    CoinItem(coin = item, onClick)
                }
                if (state.value.isLoading)
                    item {
                        LoadingItem()
                    }
                if (state.value.error.isNotBlank())
                    item {
                        ErrorItem(state.value.error)
                    }

            })
    }
}

@Composable
fun ErrorItem(message: String) {
    Text(
        text = message,
        style = MaterialTheme.typography.titleLarge.copy(
            color = MaterialTheme.colorScheme.error,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
private fun LoadingItem() {
    Box(modifier = Modifier.fillMaxWidth()) {
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center),
            color = Color.Green
        )
    }
}

@Composable
private fun HeaderCrypto() {
    Text(
        text = "Crypto",
        Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(10.dp),
        style = MaterialTheme.typography.titleLarge.copy(
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    )
}

@Composable
private fun CoinItem(coin: Coin, onClick: (Coin) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.large)
            .clickable {
                onClick(coin)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${coin.rank}. ${coin.name}",
            style = MaterialTheme.typography.titleMedium.copy(
                color = Color.White
            ),
            overflow = TextOverflow.Clip
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            style = MaterialTheme.typography.titleMedium.copy(
                color = if (coin.isActive) Color.Green else Color.Red,
                textAlign = TextAlign.End,
                fontStyle = FontStyle.Italic
            ),
        )
    }

}