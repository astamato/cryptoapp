package creativehothouse.cryptocurrencyapp.detail.builder

import creativehothouse.cryptocurrencyapp.app.builder.ApplicationScope
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import creativehothouse.cryptocurrencyapp.detail.CoinDetailsActivity
import dagger.Component
import io.realm.Realm

@ApplicationScope
@Component(modules = [(NetworkModule::class), (CoinDetailsModule::class)])
interface CoinDetailsComponent {
  fun getCryptoCurrenciesService(): CryptoCurrenciesService

  fun inject(activity: CoinDetailsActivity)
}
