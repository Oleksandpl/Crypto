package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.LinksExtended
import com.google.gson.annotations.SerializedName

data class LinksExtendedDto(
    @SerializedName("stats")
    val statsDto: StatsDto?,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

fun LinksExtendedDto.toLinksExtended(): LinksExtended {
    return LinksExtended(
        statsDto?.toStats(), type, url
    )
}