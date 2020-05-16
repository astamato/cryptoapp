package creativehothouse.cryptocurrencyapp.prices.wireframe

import android.content.Context
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.CoinDetailsActivity
import creativehothouse.cryptocurrencyapp.prices.wireframe.PricesWireframe

class DefaultPricesWireframe(private val context: Context) : PricesWireframe {

  override fun onCoinSelected(result: Coin) {
    CoinDetailsActivity.init(context, result.id)
  }

}