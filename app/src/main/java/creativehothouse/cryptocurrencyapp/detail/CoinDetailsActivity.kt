package creativehothouse.cryptocurrencyapp.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import creativehothouse.cryptocurrencyapp.R
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

  @SuppressLint("RestrictedApi")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerCoinDetailsComponent.builder().networkModule(NetworkModule(this))
        .coinDetailsModule(CoinDetailsModule(this)).build()
        .inject(this)

    setContentView(presenter.getView())
    val toolbar = findViewById<Toolbar>(R.id.appToolbar)
    setSupportActionBar(toolbar)
    supportActionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
    supportActionBar!!.setDisplayShowHomeEnabled(true)
    toolbar.setNavigationOnClickListener { onBackPressed() }

    presenter.create(intent.getIntExtra(SELECTED_COIN, 0))

  }


  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }

}