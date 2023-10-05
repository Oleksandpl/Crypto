package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Team
import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)

fun TeamDto.toTeam(): Team {
    return Team(
        id, name, position
    )
}