package com.example.crypto.domain.model.details

data class CoinDetails (
    val description: String,
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tag: List<Tag>,
    val team: List<Team>,
    val whitepaper: Whitepaper
)