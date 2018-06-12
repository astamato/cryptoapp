package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import creativehothouse.cryptocurrencyapp.prices.core.interactor.BasicAuthHeaderHelper
import io.reactivex.Observable

class DefaultPortfolioInteractor(private val service: CryptoCurrenciesService) : PortfolioInteractor {

  override fun getAuthedPortfolio(): Observable<PortfolioResponseModel> {
    return service.getPortfolio(BasicAuthHeaderHelper.getBasicAuthHeader())
  }

}