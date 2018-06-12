package creativehothouse.cryptocurrencyapp.detail.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.model.Historical

interface CoinDetailsView {

  fun getView(): View

  fun showLoading()
  fun hideLoading()

  fun showErrorLoadingCoinList()
  fun showCoinDetails(result: Coin)
  fun showCoinHistorical(historical: List<Historical>)

}