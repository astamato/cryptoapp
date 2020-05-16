package creativehothouse.cryptocurrencyapp.app.builder

import dagger.Module
import dagger.Provides
import io.realm.Realm


@Module
class RealmModule {
    @Provides
    @ApplicationScope
    internal fun provideRealmInstance(): Realm {
        return Realm.getDefaultInstance()
    }

}
