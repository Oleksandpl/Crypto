package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Tag
import com.google.gson.annotations.SerializedName

data class TagDto(
    @SerializedName("coin_counter")
    val coinCounter: Int,
    @SerializedName("ico_counter")
    val icoCounter: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

fun TagDto.toTag(): Tag {
    return Tag(
        coinCounter, icoCounter, id, name
    )
}