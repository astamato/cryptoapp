package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel

interface CoinDetailsPresenter {

  fun create(coinId: Int)
  fun destroy()
  fun getView(): View
  fun onLoadCoinHistoricalSuccess(result: HistoricalReponseModel)
  fun onLoadCoinDetailsSuccess(result: Coin)
  fun onLoadCoinDetailsFail(it: Throwable?)

}