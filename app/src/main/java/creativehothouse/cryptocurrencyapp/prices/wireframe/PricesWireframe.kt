package creativehothouse.cryptocurrencyapp.prices.wireframe

import creativehothouse.cryptocurrencyapp.app.model.Coin

interface PricesWireframe {
  fun onCoinSelected(result: Coin)
}