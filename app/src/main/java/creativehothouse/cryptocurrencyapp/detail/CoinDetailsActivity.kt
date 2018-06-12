package creativehothouse.cryptocurrencyapp.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.detail.builder.CoinDetailsModule
import creativehothouse.cryptocurrencyapp.detail.builder.DaggerCoinDetailsComponent
import creativehothouse.cryptocurrencyapp.detail.core.presenter.CoinDetailsPresenter
import javax.inject.Inject

class CoinDetailsActivity : AppCompatActivity() {

  @Inject
  lateinit var presenter: CoinDetailsPresenter

  companion object {
    const val SELECTED_COIN = "SELECTED_COIN"

    fun init(context: Context, coin: Int) {
      val intent = Intent(context, CoinDetailsActivity::class.java)

      intent.putExtra(SELECTED_COIN, coin)
      context.startActivity(intent)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerCoinDetailsComponent.builder().networkModule(NetworkModule(this))
        .coinDetailsModule(CoinDetailsModule(this)).build()
        .inject(this)

    presenter.create(intent.getIntExtra(SELECTED_COIN, 0))

    setContentView(presenter.getView())
  }

}