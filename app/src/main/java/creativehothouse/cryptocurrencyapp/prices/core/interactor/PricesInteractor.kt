package creativehothouse.cryptocurrencyapp.prices.core.interactor

import creativehothouse.cryptocurrencyapp.app.model.ResponseModel
import io.reactivex.Observable

interface PricesInteractor {

  fun getCryptoCurrenciesList(): Observable<ResponseModel>
}