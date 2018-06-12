package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date

open class Trade @JvmOverloads constructor(@SerializedName("coin_id") @PrimaryKey var coin: Int = 0,
    var amount: Float = 0f,
    @SerializedName("price_usd") var priceUSD: Float? = null,
    @SerializedName("traded_at") var tradedAt: Date? = null,
    var notes: String? = null,
    var name: String? = null,
    var symbol: String? = null) : RealmObject()