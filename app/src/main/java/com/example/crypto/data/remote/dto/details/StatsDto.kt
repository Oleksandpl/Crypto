package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Stats
import com.google.gson.annotations.SerializedName

data class StatsDto(
    @SerializedName("contributors")
    val contributors: Int?,
    @SerializedName("stars")
    val stars: Int?,
    @SerializedName("subscribers")
    val subscribers: Int?
)

fun StatsDto.toStats(): Stats {
    return Stats(
        contributors, stars, subscribers
    )
}