package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Links
import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("explorer")
    val explorer: List<String>,
    @SerializedName("facebook")
    val facebook: List<String>,
    @SerializedName("medium")
    val medium: Any?,
    @SerializedName("reddit")
    val reddit: List<String>,
    @SerializedName("source_code")
    val sourceCode: List<String>,
    @SerializedName("website")
    val website: List<String>,
    @SerializedName("youtube")
    val youtube: List<String>
)

fun LinksDto.toLinks(): Links {
    return Links(
        explorer, facebook, medium, reddit, sourceCode, website, youtube
    )
}