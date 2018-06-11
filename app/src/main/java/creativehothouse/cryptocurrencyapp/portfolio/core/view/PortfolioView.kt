package creativehothouse.cryptocurrencyapp.portfolio.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin

interface PortfolioView {
  fun getView(): View

  fun showLoading()
  fun hideLoading()
  fun drawPortfolio(coins: List<Coin>)

  fun showErrorLoadingCoinList()

}