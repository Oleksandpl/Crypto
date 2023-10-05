package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Whitepaper
import com.google.gson.annotations.SerializedName

data class WhitepaperDto(
    @SerializedName("link")
    val link: String,
    @SerializedName("thumbnail")
    val thumbnail: String?
)

fun WhitepaperDto.toWhitepaper(): Whitepaper {
    return Whitepaper(
        thumbnail
    )
}