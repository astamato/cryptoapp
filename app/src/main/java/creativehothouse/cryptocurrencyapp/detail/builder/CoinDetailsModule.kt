package creativehothouse.cryptocurrencyapp.detail.builder

import android.app.Activity
import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.detail.core.presenter.CoinDetailsPresenter
import creativehothouse.cryptocurrencyapp.detail.core.presenter.DefaultCoinDetailsPresenter
import creativehothouse.cryptocurrencyapp.detail.core.view.CoinDetailsView
import creativehothouse.cryptocurrencyapp.detail.core.view.DefaultCoinDetailsView
import creativehothouse.cryptocurrencyapp.detail.interactor.CoinDetailsInteractor
import creativehothouse.cryptocurrencyapp.detail.interactor.DefaultCoinDetailsInteractor
import creativehothouse.cryptocurrencyapp.detail.wireframe.CoinDetailsWireframe
import creativehothouse.cryptocurrencyapp.detail.wireframe.DefaultCoinDetailsWireframe
import dagger.Module
import dagger.Provides

@Module
class CoinDetailsModule(val context: Activity) {

  @Provides
  @ApplicationScope
  fun provideCoinDetailsPresenter(view: CoinDetailsView, interactor: CoinDetailsInteractor, wireframe: CoinDetailsWireframe
  ): CoinDetailsPresenter {
    return DefaultCoinDetailsPresenter(view, interactor, wireframe)
  }

  @Provides
  @ApplicationScope
  fun provideCoinDetailsView(): CoinDetailsView {
    return DefaultCoinDetailsView(context)
  }

  @Provides
  @ApplicationScope
  fun provideCoinDetailsWireframe(): CoinDetailsWireframe {
    return DefaultCoinDetailsWireframe(context)
  }

  @Provides
  @ApplicationScope
  fun providePortfolioInteractor(service: CryptoCurrenciesService): CoinDetailsInteractor {
    return DefaultCoinDetailsInteractor(service)
  }

}