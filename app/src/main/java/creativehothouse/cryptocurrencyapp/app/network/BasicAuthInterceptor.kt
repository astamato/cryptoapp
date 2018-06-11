package creativehothouse.cryptocurrencyapp.app.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BasicAuthInterceptor() : Interceptor {

  private lateinit var credentials: String

  constructor(user: String, password: String) : this() {
    this.credentials = Credentials.basic(user, password)
  }

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    val request = chain.request()
    val authenticatedRequest = request.newBuilder()
        .header("Authorization", credentials).build()
    return chain.proceed(authenticatedRequest)
  }

}
