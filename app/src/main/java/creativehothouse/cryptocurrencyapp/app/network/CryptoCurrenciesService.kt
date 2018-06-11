package creativehothouse.cryptocurrencyapp.app.network

import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.ResponseModel
import creativehothouse.cryptocurrencyapp.app.model.Trade
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoCurrenciesService {

  @GET("/coins")
  fun getCryptoCurrenciesList(): Observable<ResponseModel>

  @GET("/coins")
  fun getCryptoCurrenciesListByPage(@Query("page") page: Int): Observable<ResponseModel>

  @GET("/coins/{coin_id}")
  fun getCryptoCurrencyInfoById(@Path("coin_id") page: Int): Observable<Coin>

  @GET("/portfolio")
  fun getPortfolio(@Header("Authorization") authHeader: String): Observable<Trade>

  @POST("/portfolio")
  fun storeNewTradeInPortfolio(@Header("Authorization") authHeader: String): Observable<Trade>

}