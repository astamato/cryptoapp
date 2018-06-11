package creativehothouse.cryptocurrencyapp.prices.core.presenter

import creativehothouse.cryptocurrencyapp.app.model.Coin

interface PricesWireframe {
  fun onCoinSelected(result: Coin)
}