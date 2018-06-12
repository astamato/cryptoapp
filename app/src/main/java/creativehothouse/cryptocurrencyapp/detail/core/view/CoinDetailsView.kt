package creativehothouse.cryptocurrencyapp.detail.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import io.reactivex.Observable

interface CoinDetailsView {

  fun getView(): View

  fun showLoading()
  fun hideLoading()

  fun observeAddToPortfolioClicks(): Observable<Unit>

  fun showCoinHistorical(coin: Coin, historical: List<Historical>)
  fun showErrorLoadingCoinHistorical()
  fun enableAddToPortfolioButton()
  fun displaySuccessAddToPortfolioDialog(coin: Coin, trade: Trade)
}