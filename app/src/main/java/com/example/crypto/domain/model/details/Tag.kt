package com.example.crypto.domain.model.details

import com.google.gson.annotations.SerializedName

data class Tag(
    val coinCounter: Int,
    val icoCounter: Int,
    val id: String,
    val name: String
)
