package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.core.view.CoinDetailsView
import creativehothouse.cryptocurrencyapp.detail.interactor.CoinDetailsInteractor
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import creativehothouse.cryptocurrencyapp.detail.wireframe.CoinDetailsWireframe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DefaultCoinDetailsPresenter(val view: CoinDetailsView,
    val interactor: CoinDetailsInteractor, val wireframe: CoinDetailsWireframe) : CoinDetailsPresenter {

  private var coinId: Int = 0
  private var disposables = CompositeDisposable()
  private lateinit var coinDetails: Coin
  private lateinit var history: List<Historical>


  override fun create(coinId: Int) {
    this.coinId = coinId
    disposables.add(observeGetCoinHistorical())
  }

  override fun getView(): View = view.getView()


  override fun onLoadCoinDetailsFail(it: Throwable?) {
    view.hideLoading()
    view.showErrorLoadingCoinHistorical()
  }

  private fun observeGetCoinHistorical(): Disposable {
    return interactor.getCoinHistorical(coinId).map { it }
        .flatMap { response ->
          history = response.historical
          return@flatMap interactor.getCoinDetails(coinId)
        }.subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { response ->
              coinDetails = response.coin
              onLoadCoinHistoricalSuccess()
            },
            { throwable -> onLoadCoinDetailsFail(throwable) }
        )
  }

  override fun onLoadCoinHistoricalSuccess() {
    view.hideLoading()
    view.showCoinHistorical(coinDetails, history)
  }

  override fun destroy() {
    disposables.clear()
  }

}