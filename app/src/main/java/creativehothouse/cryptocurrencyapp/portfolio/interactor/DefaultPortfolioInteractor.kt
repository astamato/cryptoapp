package creativehothouse.cryptocurrencyapp.portfolio.interactor

import android.util.Log
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import creativehothouse.cryptocurrencyapp.prices.core.interactor.BasicAuthHeaderHelper
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmResults
import io.realm.rx.CollectionChange


class DefaultPortfolioInteractor(private val service: CryptoCurrenciesService) : PortfolioInteractor {
  override fun getCoinsInDB(realm: Realm): Observable<CollectionChange<RealmResults<Trade>>> {
    return realm.where(Trade::class.java).findAll().asChangesetObservable()
  }

  override fun storeCoinsInDB(realm: Realm, coins: List<Trade>) {
    Log.d("", "path: " + realm.path)
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