package creativehothouse.cryptocurrencyapp.prices.core.interactor

import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import io.reactivex.Observable

interface PricesInteractor {

  fun getCryptoCurrenciesList(): Observable<PricesListResponseModel>
}