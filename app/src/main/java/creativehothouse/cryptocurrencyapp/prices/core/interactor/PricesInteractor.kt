package creativehothouse.cryptocurrencyapp.prices.core.interactor

import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import io.reactivex.Observable

interface PricesInteractor {

  fun getCryptoCurrenciesList(): Observable<PricesListResponseModel>
  fun storeOrUpdatePagesModel(result: PricesListResponseModel)
  fun getNextPage(): Int
  fun hasNextPage(): Boolean
  fun getCryptoCurrenciesListByPage(nextPage: Int): Observable<PricesListResponseModel>
}