package creativehothouse.cryptocurrencyapp.detail.core.view

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.jakewharton.rxbinding2.view.clicks
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import io.reactivex.Observable


class DefaultCoinDetailsView(context: Context?) : CoinDetailsView, LinearLayout(context) {

  private var progressBar: ProgressBar
  private var chart: LineChart
  private var toolbar: Toolbar

  init {
    inflate(context, R.layout.coin_details_view, this)
    toolbar = findViewById(R.id.appToolbar)
    toolbar.title = context?.getString(R.string.coin_details_screen)
    progressBar = findViewById(R.id.progressBar)
    chart = findViewById(R.id.chart)

  }

  override fun hideLoading() {
    progressBar.visibility = View.INVISIBLE
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun getView(): View {
    return this
  }


  override fun showErrorLoadingCoinHistorical() {
    val container = getView().findViewById(R.id.placeSnackBar) as ViewGroup
    Snackbar.make(container
        , R.string.onErrorLoad, Snackbar.LENGTH_LONG)
        .show()
  }


  override fun showCoinHistorical(coin: Coin, historical: List<Historical>) {

    showCoinDetails(coin)

    val entries = ArrayList<Entry>()

    // for (data in historical) {
    entries.add(Entry(1f, 4f))
    entries.add(Entry(2f, 3f))
    entries.add(Entry(3f, 6f))
    //}

    val dataSet = LineDataSet(entries, coin.name)
    val lineData = LineData(dataSet)
    chart.data = lineData

    val description = Description()
    description.text = "Historical evolution of cryptocoin"

    chart.description = description
    chart.invalidate()

  }

  private fun showCoinDetails(coin: Coin) {
    toolbar.title = coin.name
  }

  override fun observeToolbarClick(): Observable<Unit> {
    return toolbar.clicks()
  }

}