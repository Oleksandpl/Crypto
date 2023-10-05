package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Parent
import com.google.gson.annotations.SerializedName

data class ParentDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)

fun ParentDto.toParent(): Parent {
    return Parent(
        id, name, symbol
    )
}