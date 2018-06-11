package creativehothouse.cryptocurrencyapp.portfolio.core.presenter

import android.view.View
import creativehothouse.cryptocurrencyapp.portfolio.core.view.PortfolioView
import creativehothouse.cryptocurrencyapp.portfolio.interactor.PortfolioInteractor
import creativehothouse.cryptocurrencyapp.portfolio.model.PortfolioResponseModel
import creativehothouse.cryptocurrencyapp.portfolio.wireframe.PortfolioWireframe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DefaultPortfolioPresenter(val view: PortfolioView,
    val interactor: PortfolioInteractor,
    val wireframe: PortfolioWireframe) : PortfolioPresenter {


  private var disposables = CompositeDisposable()

  override fun create() {
    disposables.add(this.observeGetPortfolio())
  }


  override fun getView(): View = view.getView()

  override fun onGetPortfolioSuccess(result: PortfolioResponseModel) {
    view.hideLoading()
    //FIXME !!!
    view.drawPortfolio(result.coins)
  }

  override fun onGetPortfolioFail(it: Throwable?) {
    view.hideLoading()
    view.showErrorLoadingCoinList()
  }

  private fun observeGetPortfolio(): Disposable {
    return interactor.getAuthedPortfolio()
        .subscribeOn(Schedulers.io())
        .doOnSubscribe { view.showLoading() }
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> onGetPortfolioSuccess(result) },
            { throwable -> onGetPortfolioFail(throwable) }
        )
  }

  override fun destroy() {
    disposables.clear()
  }

}