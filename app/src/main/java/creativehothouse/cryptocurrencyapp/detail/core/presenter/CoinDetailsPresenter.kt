package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View

interface CoinDetailsPresenter {

  fun create(coinId: Int)
  fun destroy()
  fun getView(): View
  fun onLoadCoinHistoricalSuccess()
  fun onLoadCoinDetailsFail(it: Throwable?)

}