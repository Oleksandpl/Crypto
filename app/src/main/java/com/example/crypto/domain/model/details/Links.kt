package com.example.crypto.domain.model.details

import com.google.gson.annotations.SerializedName

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val medium: Any?,
    val reddit: List<String>,
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
