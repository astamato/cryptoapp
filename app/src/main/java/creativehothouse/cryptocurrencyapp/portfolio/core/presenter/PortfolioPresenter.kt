package creativehothouse.cryptocurrencyapp.portfolio.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel

interface PortfolioPresenter {

  fun create()
  fun destroy()
  fun getView(): View
  fun onGetPortfolioFail(it: Throwable?)

  fun onGetPortfolioSuccess(result: List<Trade>)
}