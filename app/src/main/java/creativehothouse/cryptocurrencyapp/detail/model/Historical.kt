package creativehothouse.cryptocurrencyapp.detail.model

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Historical(
    @SerializedName("price_usd") val priceUSD: String,
    @SerializedName("snapshot_at") val snapshot: Date)
