package creativehothouse.cryptocurrencyapp.portfolio.model

import creativehothouse.cryptocurrencyapp.app.model.Trade

//FIXME should potentially be Trade??
data class PortfolioResponseModel(val coins: List<Trade>)