package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import creativehothouse.cryptocurrencyapp.prices.core.interactor.BasicAuthHeaderHelper
import io.reactivex.Observable

class DefaultPortfolioInteractor(private val service: CryptoCurrenciesService) : PortfolioInteractor {

  private val basicAuthHeader: String = BasicAuthHeaderHelper.getBasicAuthHeader()

  override fun getAuthedPortfolio(): Observable<PortfolioResponseModel> {
    return service.getPortfolio(basicAuthHeader)
  }

  override fun storeNewTradeToPortfolio(coin: Coin): Observable<Trade> {
    return service.storeNewTradeInPortfolio(basicAuthHeader, coin)
  }

}