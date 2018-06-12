package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Trade(@SerializedName("coin_id") val coin: String,
    val amount: String,
    @SerializedName("price_usd") val priceUSD: String,
    @SerializedName("traded_at") val tradedAt: Date,
    val notes: String,
    var name: String?,
    var symbol: String?)
