package creativehothouse.cryptocurrencyapp.prices.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import io.reactivex.disposables.Disposable

interface PricesPresenter {

  fun create()
  fun destroy()
  fun getView(): View
  fun onGetCryptoCurrenciesListSuccess(coins: PricesListResponseModel)
  fun onGetCryptoCurrenciesListFail(it: Throwable?)
  fun onCryptoCurrencyIsSelected(): Disposable

}