package creativehothouse.cryptocurrencyapp.prices.core.view

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.PricesListResponseModel
import creativehothouse.cryptocurrencyapp.prices.core.view.adapter.CoinsPricesAdapter
import io.reactivex.Observable


class DefaultPricesView(context: Context) : LinearLayout(context), PricesView {

  private lateinit var adapter: CoinsPricesAdapter

  private var progressBar: ProgressBar

  init {
    inflate(context, R.layout.fragment_prices_list, this)
    progressBar = findViewById(R.id.progressBar)
  }

  override fun getView(): View {
    return this
  }

  override fun hideLoading() {
    progressBar.visibility = View.GONE
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun drawCoinsList(responseModel: PricesListResponseModel) {
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    recyclerView.layoutManager = LinearLayoutManager(context)
    adapter = CoinsPricesAdapter(responseModel.coins.data)
    recyclerView.adapter = adapter
  }

  override fun onCoinIsSelected(): Observable<Coin> {
    return adapter.clickCoinEvent
  }

  override fun showErrorLoadingCoinList() {
    val container = getView().findViewById(R.id.placeSnackBar) as ViewGroup
    Snackbar.make(container
        , R.string.onErrorLoad, Snackbar.LENGTH_LONG)
        .show()
  }

}