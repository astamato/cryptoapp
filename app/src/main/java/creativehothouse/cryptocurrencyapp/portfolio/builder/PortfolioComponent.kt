package creativehothouse.cryptocurrencyapp.portfolio.builder

import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.app.builder.RealmModule
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.portfolio.PortfolioFragment
import dagger.Component
import io.realm.Realm

@ApplicationScope
@Component(modules = [(NetworkModule::class), (PortfolioModule::class), (RealmModule::class)])
interface PortfolioComponent {

  fun getCryptoCurrenciesService(): CryptoCurrenciesService

  fun getRealm(): Realm

  fun inject(fragment: PortfolioFragment)
}