package creativehothouse.cryptocurrencyapp.app.builder

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import creativehothouse.cryptocurrencyapp.app.network.CryptoCurrenciesService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


@Module
class NetworkModule(private var context: Context) {
    companion object {
        const val CONNECTION_TIMEOUT_SECONDS = 30
        const val HTTP_CACHE_DIR_NAME = "okhttp_cache"
        const val DISK_CACHE_SIZE = 50 * 1024 * 1024 // 50MB

        const val CRYPTO_CURRENCIES_SERVICE_BASE_URL = "https://test.cryptojet.io"

        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    }

    @Provides
    @ApplicationScope
    internal fun provideOkHttpClient(): OkHttpClient {
        val cacheDir = File(context.cacheDir, HTTP_CACHE_DIR_NAME)
        val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())

        return OkHttpClient.Builder().connectTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(),
                TimeUnit.SECONDS)
                .readTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .writeTimeout(CONNECTION_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .cache(cache).build()
    }

    @Provides
    @ApplicationScope
    internal fun provideGson(): Gson = GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .create()


    @Provides
    @ApplicationScope
    internal fun provideRetrofit(okhttp: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create(gson)).client(okhttp)
                .baseUrl(CRYPTO_CURRENCIES_SERVICE_BASE_URL)
                .build()
    }

    @Provides
    @ApplicationScope
    internal fun provideCryptoCurrenciesService(retrofit: Retrofit): CryptoCurrenciesService {
        return retrofit.create(CryptoCurrenciesService::class.java)
    }

}
