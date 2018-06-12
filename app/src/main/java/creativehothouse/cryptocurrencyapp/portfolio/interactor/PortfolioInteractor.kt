package creativehothouse.cryptocurrencyapp.portfolio.interactor

import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import io.reactivex.Observable

interface PortfolioInteractor {
  fun getAuthedPortfolio(): Observable<PortfolioResponseModel>
}