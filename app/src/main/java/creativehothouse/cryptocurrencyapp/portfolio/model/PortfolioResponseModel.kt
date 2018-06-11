package creativehothouse.cryptocurrencyapp.portfolio.model

import creativehothouse.cryptocurrencyapp.app.model.Coin

//FIXME should potentially be Trade??
data class PortfolioResponseModel(val coins: List<Coin>)