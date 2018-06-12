package creativehothouse.cryptocurrencyapp.detail.interactor

import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.CoinResponse
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel
import io.reactivex.Observable

class DefaultCoinDetailsInteractor(val service: CryptoCurrenciesService) : CoinDetailsInteractor {

  override fun getCoinDetails(coinId: Int): Observable<CoinResponse> {
    return service.getCryptoCurrencyInfoById(coinId)
  }

  override fun getCoinHistorical(coinId: Int): Observable<HistoricalReponseModel> {
    return service.getCoinHistorical(coinId)
  }


}