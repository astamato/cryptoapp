package creativehothouse.cryptocurrencyapp.detail.interactor

import creativehothouse.cryptocurrencyapp.app.model.CoinResponse
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.app.model.TradeResponse
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel
import creativehothouse.cryptocurrencyapp.prices.core.interactor.BasicAuthHeaderHelper
import io.reactivex.Observable

class DefaultCoinDetailsInteractor(private val service: CryptoCurrenciesService) : CoinDetailsInteractor {
  override fun addToPortfolio(trade: Trade): Observable<TradeResponse> {
    return service.storeNewTradeInPortfolio(BasicAuthHeaderHelper.getBasicAuthHeader(), trade)
  }

  override fun getCoinDetails(coinId: Int): Observable<CoinResponse> {
    return service.getCryptoCurrencyInfoById(coinId)
  }

  override fun getCoinHistorical(coinId: Int): Observable<HistoricalReponseModel> {
    return service.getCoinHistorical(coinId)
  }

}