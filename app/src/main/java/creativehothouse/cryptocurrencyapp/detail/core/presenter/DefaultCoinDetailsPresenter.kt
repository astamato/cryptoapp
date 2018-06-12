package creativehothouse.cryptocurrencyapp.detail.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.detail.core.view.CoinDetailsView
import creativehothouse.cryptocurrencyapp.detail.interactor.CoinDetailsInteractor
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import creativehothouse.cryptocurrencyapp.detail.wireframe.CoinDetailsWireframe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.Date


class DefaultCoinDetailsPresenter(val view: CoinDetailsView,
    val interactor: CoinDetailsInteractor, val wireframe: CoinDetailsWireframe) : CoinDetailsPresenter {

  private var coinId: Int = 0
  private var disposables = CompositeDisposable()
  private lateinit var coinDetails: Coin
  private lateinit var history: List<Historical>


  override fun create(coinId: Int) {
    this.coinId = coinId
    disposables.addAll(observeGetCoinHistorical())
  }

  override fun getView(): View = view.getView()


  override fun onLoadFailed(it: Throwable?) {
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
              disposables.add(subscribeOnAddToPortfolioClicks())
              onLoadCoinHistoricalSuccess()
            },
            { throwable -> onLoadFailed(throwable) }
        )
  }


  private fun subscribeOnAddToPortfolioClicks(): Disposable {
    return view.observeAddToPortfolioClicks()
        .subscribe({ disposables.add(onButtonAddToPortfolioClick()) })
  }

  private fun onButtonAddToPortfolioClick(): Disposable {
    val trade = Trade(coinDetails.id, 54f, 56f, Date())

    return interactor.addToPortfolio(trade).subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> onAddToPortfolioSuccess(result) },
            { throwable -> onLoadFailed(throwable) }
        )
  }

  override fun onLoadCoinHistoricalSuccess() {
    view.hideLoading()
    view.enableAddToPortfolioButton()
    view.showCoinHistorical(coinDetails, history)
  }

  override fun onAddToPortfolioSuccess(result: Trade) {
    //FIXME store realm data!!!
    view.displaySuccessAddToPortfolioDialog(coinDetails, result)
  }

  override fun destroy() {
    disposables.clear()
  }

}