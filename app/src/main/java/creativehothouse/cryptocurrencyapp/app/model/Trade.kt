package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName

data class Trade(@SerializedName("coin_id") val coin: String,
    val amount: String,
    @SerializedName("price_usd") val priceUSD: String,
    @SerializedName("traded_at") val tradedAt: String,
    val notes: String
)
