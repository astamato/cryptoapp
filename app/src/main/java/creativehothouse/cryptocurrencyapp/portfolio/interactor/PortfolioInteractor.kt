package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmResults
import io.realm.rx.CollectionChange

interface PortfolioInteractor {
  fun getAuthedPortfolio(): Observable<PortfolioResponseModel>
  fun storeCoinsInDB(realm: Realm, coins: List<Trade>)
  fun getCoinsInDB(realm: Realm): Observable<CollectionChange<RealmResults<Trade>>>
}