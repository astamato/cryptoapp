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
import io.reactivex.subjects.PublishSubject


class DefaultPricesView(context: Context) : LinearLayout(context), PricesView {

  val clickOnLoadMore = PublishSubject.create<Boolean>()!!

  private lateinit var adapter: CoinsPricesAdapter
  private var layoutManager: LinearLayoutManager
  private var progressBar: ProgressBar
  private val visibleThreshold = 5
  private var loading: Boolean = false

  init {
    inflate(context, R.layout.fragment_prices_list, this)
    progressBar = findViewById(R.id.progressBar)
    layoutManager = LinearLayoutManager(context)
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

  override fun setLoaded() {
    loading = false
  }

  override fun addToCoins(responseModel: PricesListResponseModel) {
    adapter.addToCoins(responseModel.coins.data)
  }

  override fun drawCoinsList(responseModel: PricesListResponseModel) {
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    recyclerView.layoutManager = layoutManager
    recyclerView
        .addOnScrollListener(object : RecyclerView.OnScrollListener() {
          override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            var totalItemCount = layoutManager.itemCount
            var lastVisibleItem = layoutManager
                .findLastVisibleItemPosition()
            if (!loading
                && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
              clickOnLoadMore.onNext(true)
              loading = true
            }
          }
        })
    adapter = CoinsPricesAdapter(responseModel.coins.data)


    recyclerView.adapter = adapter
  }

  override fun onCoinIsSelected(): Observable<Coin> {
    return adapter.clickCoinEvent
  }

  override fun onLoadMore(): Observable<Boolean> {
    return clickOnLoadMore
  }

  override fun showErrorLoadingCoinList() {
    val container = getView().findViewById(R.id.placeSnackBar) as ViewGroup
    Snackbar.make(container
        , R.string.onErrorLoad, Snackbar.LENGTH_LONG)
        .show()
  }

}