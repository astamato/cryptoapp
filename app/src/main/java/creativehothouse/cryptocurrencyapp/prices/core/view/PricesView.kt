package creativehothouse.cryptocurrencyapp.prices.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.ResponseModel
import io.reactivex.Observable

interface PricesView {
  fun getView(): View

  fun showLoading()
  fun hideLoading()

  fun drawCoinsList(responseModel: ResponseModel)
  fun onCoinIsSelected(): Observable<Coin>

  fun showErrorLoadingCoinList()
}