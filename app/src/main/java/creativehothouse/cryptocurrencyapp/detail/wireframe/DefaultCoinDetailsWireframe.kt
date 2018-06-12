package creativehothouse.cryptocurrencyapp.detail.wireframe

import android.app.Activity

class DefaultCoinDetailsWireframe(var activity: Activity) : CoinDetailsWireframe {
  override fun onNavigateBack() {
    activity.onBackPressed()
  }

}
