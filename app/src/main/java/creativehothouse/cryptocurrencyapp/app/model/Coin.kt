package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName

data class Coin(val id: Int,
    val name: String,
    val symbol: String,
    @SerializedName("price_usd") val priceUSD: String,
    @SerializedName("percent_change_24h") val percentChange24h: String)
