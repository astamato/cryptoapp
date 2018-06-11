package creativehothouse.cryptocurrencyapp.portfolio.builder

import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.PortfolioFragment
import dagger.Component

@ApplicationScope
@Component(modules = [(NetworkModule::class), (PortfolioModule::class)])
interface PortfolioComponent {

  fun getCryptoCurrenciesService(): CryptoCurrenciesService

  fun inject(fragment: PortfolioFragment)
}