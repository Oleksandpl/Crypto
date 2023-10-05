package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.Contract
import com.google.gson.annotations.SerializedName

data class ContractDto(
    @SerializedName("contract")
    val contract: String,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("type")
    val type: String
)

fun ContractDto.toContract(): Contract {
    return Contract(
        contract, platform, type
    )
}
