package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Trade

interface CoinDetailsPresenter {

  fun create(coinId: Int)
  fun destroy()
  fun getView(): View
  fun onLoadCoinHistoricalSuccess()
  fun onLoadFailed(it: Throwable?)
  fun onAddToPortfolioSuccess(result: Trade)
}