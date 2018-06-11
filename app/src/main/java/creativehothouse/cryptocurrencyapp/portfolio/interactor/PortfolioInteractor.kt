package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import io.reactivex.Observable


interface PortfolioInteractor {
  fun getAuthedPortfolio(): Observable<PortfolioResponseModel>
  fun storeNewTradeToPortfolio(coin: Coin): Observable<Trade>
}