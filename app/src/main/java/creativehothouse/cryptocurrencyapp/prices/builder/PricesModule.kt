package creativehothouse.cryptocurrencyapp.prices.builder

import android.content.Context
import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.prices.core.interactor.DefaultPricesInteractor
import creativehothouse.cryptocurrencyapp.prices.core.interactor.PricesInteractor
import creativehothouse.cryptocurrencyapp.prices.core.presenter.DefaultPricesPresenter
import creativehothouse.cryptocurrencyapp.prices.core.presenter.DefaultPricesWireframe
import creativehothouse.cryptocurrencyapp.prices.core.presenter.PricesPresenter
import creativehothouse.cryptocurrencyapp.prices.core.presenter.PricesWireframe
import creativehothouse.cryptocurrencyapp.prices.core.view.DefaultPricesView
import creativehothouse.cryptocurrencyapp.prices.core.view.PricesView
import dagger.Module
import dagger.Provides


@Module
class PricesModule(private val context: Context) {

  @Provides
  @ApplicationScope
  fun providePricesDisplayPresenter(view: PricesView, interactor: PricesInteractor, wireframe: PricesWireframe): PricesPresenter {
    return DefaultPricesPresenter(view, interactor, wireframe)
  }

  @Provides
  @ApplicationScope
  fun providePricesView(): PricesView {
    return DefaultPricesView(context)
  }

  @Provides
  @ApplicationScope
  fun providePricesInteractor(service: CryptoCurrenciesService): PricesInteractor {
    return DefaultPricesInteractor(service)
  }

  @Provides
  @ApplicationScope
  fun providePricesWireframe(): PricesWireframe {
    return DefaultPricesWireframe(context)
  }


}
