package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Trade @JvmOverloads constructor(@SerializedName("coin_id") val coin: Int,
    val amount: Float,
    @SerializedName("price_usd") val priceUSD: Float,
    @SerializedName("traded_at") val tradedAt: Date,
    val notes: String? = null,
    var name: String? = null,
    var symbol: String? = null)
