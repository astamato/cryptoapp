package creativehothouse.cryptocurrencyapp.prices.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.ResponseModel
import io.reactivex.disposables.Disposable

interface PricesPresenter {

  fun create()
  fun destroy()
  fun getView(): View
  fun onGetCryptoCurrenciesListSuccess(coins: ResponseModel)
  fun onGetCryptoCurrenciesListFail(it: Throwable?)
  fun onCryptoCurrencyIsSelected(): Disposable

}