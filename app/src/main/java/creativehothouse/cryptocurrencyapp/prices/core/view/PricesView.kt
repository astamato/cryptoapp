package creativehothouse.cryptocurrencyapp.prices.core.view

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import io.reactivex.Observable

interface PricesView {
  fun getView(): View

  fun showLoading()
  fun hideLoading()

  fun drawCoinsList(responseModel: PricesListResponseModel)
  fun onCoinIsSelected(): Observable<Coin>

  fun showErrorLoadingCoinList()
  fun onLoadMore(): Observable<Boolean>
  fun addToCoins(responseModel: PricesListResponseModel)
  fun setLoaded()
}