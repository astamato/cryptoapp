package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.core.view.CoinDetailsView
import creativehothouse.cryptocurrencyapp.detail.interactor.CoinDetailsInteractor
import creativehothouse.cryptocurrencyapp.detail.model.HistoricalReponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DefaultCoinDetailsPresenter(val view: CoinDetailsView,
    val interactor: CoinDetailsInteractor) : CoinDetailsPresenter {

  var coinId: Int = 0

  private var disposables = CompositeDisposable()

  override fun create(coinId: Int) {
    this.coinId = coinId
    disposables.add(this.observeGetCoinDetails())
    disposables.add(this.observeGetCoinHistorical())
  }

  override fun getView(): View = view.getView()

  override fun onLoadCoinDetailsFail(it: Throwable?) {
    view.hideLoading()
    view.showErrorLoadingCoinList()
  }

  private fun observeGetCoinDetails(): Disposable {
    return interactor.getCoinDetails(coinId)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> onLoadCoinDetailsSuccess(result.coin) },
            { throwable -> onLoadCoinDetailsFail(throwable) }
        )
  }

  private fun observeGetCoinHistorical(): Disposable {
    return interactor.getCoinHistorical(coinId)
        .subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> onLoadCoinHistoricalSuccess(result) },
            { throwable -> onLoadCoinDetailsFail(throwable) }
        )
  }

  override fun onLoadCoinHistoricalSuccess(result: HistoricalReponseModel) = view.showCoinHistorical(result.historical)

  override fun onLoadCoinDetailsSuccess(result: Coin) = view.showCoinDetails(result)

  override fun destroy() {
    disposables.clear()
  }

}