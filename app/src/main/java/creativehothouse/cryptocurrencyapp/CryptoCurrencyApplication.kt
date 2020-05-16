package creativehothouse.cryptocurrencyapp

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class CryptoCurrencyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
                .name("cryptocurrency.realm")
                .schemaVersion(0)
                .build()
        Realm.setDefaultConfiguration(realmConfig)
    }

}
