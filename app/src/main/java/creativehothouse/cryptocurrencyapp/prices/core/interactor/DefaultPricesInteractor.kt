package creativehothouse.cryptocurrencyapp.prices.core.interactor

import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import io.reactivex.Observable

class DefaultPricesInteractor(private var service: CryptoCurrenciesService) : PricesInteractor {
  private var currentPage = -1
  private var lastPage = -1

  override fun storeOrUpdatePagesModel(result: PricesListResponseModel) {
    currentPage = result.coins.currentPage
    lastPage = result.coins.lastPage
  }

  /**
   * Can also be got from the model next_url
   */
  override fun getNextPage(): Int = currentPage + 1

  /**
   * @return true if has next page of coins to load, false otherwise
   */
  override fun hasNextPage() = currentPage != lastPage

  override fun getCryptoCurrenciesList(): Observable<PricesListResponseModel> = service.getCryptoCurrenciesList()

  override fun getCryptoCurrenciesListByPage(nextPage: Int): Observable<PricesListResponseModel> = service
      .getCryptoCurrenciesListByPage(nextPage)
}