package creativehothouse.cryptocurrencyapp.app.model

import com.google.gson.annotations.SerializedName

data class PricesListResponseModel(val coins: Coins,
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int,
    @SerializedName("next_page_url") val nextPage: String) {

  data class Coins(val data: List<Coin>)

}
