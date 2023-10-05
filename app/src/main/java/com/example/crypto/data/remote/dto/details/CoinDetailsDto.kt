package com.example.crypto.data.remote.dto.details


import com.example.crypto.domain.model.details.CoinDetails
import com.google.gson.annotations.SerializedName

data class CoinDetailsDto(
    @SerializedName("contract")
    val contract: String,
    @SerializedName("contracts")
    val contractDto: List<ContractDto>,
    @SerializedName("description")
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    @SerializedName("links")
    val linksDto: LinksDto,
    @SerializedName("links_extended")
    val linksExtendedDto: List<LinksExtendedDto>,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("parent")
    val parentDto: ParentDto,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("proof_type")
    val proofType: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tagDto: List<TagDto>,
    @SerializedName("team")
    val teamDto: List<TeamDto>,
    @SerializedName("type")
    val type: String,
    @SerializedName("whitepaper")
    val whitepaperDto: WhitepaperDto
)

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        description,
        id,
        isActive,
        name,
        rank,
        symbol,
        tagDto.map { it.toTag() },
        teamDto.map { it.toTeam() },
        whitepaperDto.toWhitepaper()
    )
}