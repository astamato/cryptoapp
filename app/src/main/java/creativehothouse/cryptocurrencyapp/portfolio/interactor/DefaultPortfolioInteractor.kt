package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import creativehothouse.cryptocurrencyapp.prices.core.interactor.BasicAuthHeaderHelper
import io.reactivex.Observable
import io.realm.Realm


class DefaultPortfolioInteractor(private val service: CryptoCurrenciesService) : PortfolioInteractor {

  override fun storeCoinsInDB(realm: Realm, coins: List<Trade>) {
    realm.use { realm ->
      realm.executeTransaction { realm ->
        realm.insertOrUpdate(coins)
      }
    }
  }


  override fun getAuthedPortfolio(): Observable<PortfolioResponseModel> {
    return service.getPortfolio(BasicAuthHeaderHelper.getBasicAuthHeader())
  }

}