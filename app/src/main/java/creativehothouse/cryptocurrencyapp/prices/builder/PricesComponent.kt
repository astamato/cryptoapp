package creativehothouse.cryptocurrencyapp.prices.builder

import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.prices.PricesFragment
import dagger.Component

@ApplicationScope
@Component(modules = [(NetworkModule::class), (PricesModule::class)])
interface PricesComponent {

  fun getCryptoCurrenciesService(): CryptoCurrenciesService

  fun inject(pricesFragment: PricesFragment)
}
