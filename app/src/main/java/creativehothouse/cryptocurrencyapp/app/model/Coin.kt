package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName

data class Coin(val id: Int,
    val name: String,
    val symbol: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("price_usd") val priceUSD: String,
    @SerializedName("market_cap_usd") val marketCapUSD: Long,
    @SerializedName("available_supply") val availableSupply: Long,
    @SerializedName("total_supply") val totalSupply: Long,
    @SerializedName("percent_change_1h") val percentChange1h: String,
    @SerializedName("percent_change_24h") val percentChange24h: String,
    @SerializedName("percent_change_7d") val percentChange7D: String

)
