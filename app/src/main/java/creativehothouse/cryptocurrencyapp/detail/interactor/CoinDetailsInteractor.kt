package creativehothouse.cryptocurrencyapp.detail.interactor

import creativehothouse.cryptocurrencyapp.app.model.CoinResponse
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel
import io.reactivex.Observable

interface CoinDetailsInteractor {
  fun getCoinDetails(coinId: Int): Observable<CoinResponse>
  fun getCoinHistorical(coinId: Int): Observable<HistoricalReponseModel>
}