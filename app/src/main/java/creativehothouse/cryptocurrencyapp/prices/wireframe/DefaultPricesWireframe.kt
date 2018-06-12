package creativehothouse.cryptocurrencyapp.prices.core.presenter

import android.content.Context
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.CoinDetailsActivity

class DefaultPricesWireframe(private val context: Context) : PricesWireframe {

  override fun onCoinSelected(result: Coin) {
    CoinDetailsActivity.init(context, result.id)
  }

}