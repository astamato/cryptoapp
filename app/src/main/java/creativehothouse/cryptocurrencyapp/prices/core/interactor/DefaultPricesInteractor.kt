package creativehothouse.cryptocurrencyapp.prices.core.interactor

import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import io.reactivex.Observable

class DefaultPricesInteractor(private var service: CryptoCurrenciesService) : PricesInteractor {

  override fun getCryptoCurrenciesList(): Observable<PricesListResponseModel> {
    return service.getCryptoCurrenciesList()
  }

}