package creativehothouse.cryptocurrencyapp.app.network

import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.CoinResponse
import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoCurrenciesService {

  @GET("/coins")
  fun getCryptoCurrenciesList(): Observable<PricesListResponseModel>

  @GET("/coins")
  fun getCryptoCurrenciesListByPage(@Query("page") page: Int): Observable<PricesListResponseModel>

  @GET("/coins/{coin_id}")
  fun getCryptoCurrencyInfoById(@Path("coin_id") page: Int): Observable<CoinResponse>

  @GET("/coins/{coin_id}/historical")
  fun getCoinHistorical(@Path("coin_id") page: Int): Observable<HistoricalReponseModel>

  @GET("/portfolio")
  fun getPortfolio(@Header("Authorization") authHeader: String): Observable<PortfolioResponseModel>

  @POST("/portfolio")
  fun storeNewTradeInPortfolio(@Header("Authorization") authHeader: String, @Body trade: Trade): Observable<Trade>

}