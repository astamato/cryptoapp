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
import io.realm.Realm

class DefaultPortfolioPresenter(val view: PortfolioView,
    val interactor: PortfolioInteractor,
    val wireframe: PortfolioWireframe, val realm: Realm) : PortfolioPresenter {

  private var disposables = CompositeDisposable()

  override fun create() {
    disposables.add(this.observeGetPortfolio())
  }


  override fun getView(): View = view.getView()

  override fun onGetPortfolioSuccess(result: PortfolioResponseModel) {
    view.hideLoading()
    view.drawPortfolio(result.coins)
    interactor.storeCoinsInDB(realm, result.coins)
  }

  override fun onGetPortfolioFail(it: Throwable?) {
    view.hideLoading()

    //FIXME REALM LOAD FROM DATABASE!!!
    //if online cargar desde db
    // display banner with last valid information
    //interactor.getCoinsInDB(realm)

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
    realm.close()
    disposables.clear()
  }

}