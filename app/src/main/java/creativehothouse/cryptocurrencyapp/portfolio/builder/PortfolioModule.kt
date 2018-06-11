package creativehothouse.cryptocurrencyapp.portfolio.builder

import android.content.Context
import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.core.presenter.DefaultPortfolioPresenter
import creativehothouse.cryptocurrencyapp.portfolio.core.presenter.PortfolioPresenter
import creativehothouse.cryptocurrencyapp.portfolio.core.view.DefaultPortfolioView
import creativehothouse.cryptocurrencyapp.portfolio.core.view.PortfolioView
import creativehothouse.cryptocurrencyapp.portfolio.interactor.DefaultPortfolioInteractor
import creativehothouse.cryptocurrencyapp.portfolio.interactor.PortfolioInteractor
import creativehothouse.cryptocurrencyapp.portfolio.wireframe.DefaultPortfolioWireframe
import creativehothouse.cryptocurrencyapp.portfolio.wireframe.PortfolioWireframe

import dagger.Module
import dagger.Provides


@Module
class PortfolioModule(private val context: Context) {

  @Provides
  @ApplicationScope
  fun providePortfolioPresenter(view: PortfolioView, interactor: PortfolioInteractor,
      wireframe: PortfolioWireframe): PortfolioPresenter {
    return DefaultPortfolioPresenter(view, interactor, wireframe)
  }

  @Provides
  @ApplicationScope
  fun providePortfolioWireframe(): PortfolioWireframe {
    return DefaultPortfolioWireframe(context)
  }

  @Provides
  @ApplicationScope
  fun providePortfolioView(): PortfolioView {
    return DefaultPortfolioView(context)
  }

  @Provides
  @ApplicationScope
  fun providePortfolioInteractor(service: CryptoCurrenciesService): PortfolioInteractor {
    return DefaultPortfolioInteractor(service)
  }

}
