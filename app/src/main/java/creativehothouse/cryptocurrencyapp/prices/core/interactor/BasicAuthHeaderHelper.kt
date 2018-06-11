package creativehothouse.cryptocurrencyapp.prices.core.interactor

import android.util.Base64

class BasicAuthHeaderHelper() {
  companion object {
    private const val CRYPTO_CURRENCIES_SERVICE_LOGIN_EMAIL = "richard@rich.com"
    private const val CRYPTO_CURRENCIES_SERVICE_LOGIN_PSSWD = "secret"
    private const val BASIC_HEADER = "Basic "

    fun getBasicAuthHeader(): String {
      val auth = "$CRYPTO_CURRENCIES_SERVICE_LOGIN_EMAIL:$CRYPTO_CURRENCIES_SERVICE_LOGIN_PSSWD"
      return BASIC_HEADER + Base64.encodeToString(auth.toByteArray(), android.util.Base64.NO_WRAP)
    }
  }
}