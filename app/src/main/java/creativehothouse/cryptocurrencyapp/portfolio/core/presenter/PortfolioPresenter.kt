package creativehothouse.cryptocurrencyapp.portfolio.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel

interface PortfolioPresenter {

  fun create()
  fun destroy()
  fun getView(): View
  fun onGetPortfolioSuccess(result: PortfolioResponseModel)
  fun onGetPortfolioFail(it: Throwable?)

}