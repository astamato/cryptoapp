package creativehothouse.cryptocurrencyapp.portfolio.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Trade

interface PortfolioView {
  fun getView(): View

  fun showLoading()
  fun hideLoading()
  fun drawPortfolio(coins: List<Trade>)

  fun showErrorLoadingCoinList()

}