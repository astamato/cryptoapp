package creativehothouse.cryptocurrencyapp.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

class CoinDetailsActivity : AppCompatActivity() {

  companion object {
    const val SELECTED_COIN = "SELECTED_COIN"

    fun init(context: Context, coin: Int) {
      val intent = Intent(context, CoinDetailsActivity::class.java)

      intent.putExtra(SELECTED_COIN, coin)
      context.startActivity(intent)
    }
  }

}