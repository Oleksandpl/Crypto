package com.example.crypto.domain.model.details

import com.example.crypto.data.remote.dto.details.StatsDto

data class LinksExtended(
    val stats: Stats?,
    val type: String,
    val url: String
)
