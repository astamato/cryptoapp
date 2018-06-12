package creativehothouse.cryptocurrencyapp.detail.core.view

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.detail.model.Historical


class DefaultCoinDetailsView(context: Context?) : CoinDetailsView, LinearLayout(context) {
  private var progressBar: ProgressBar
  private var chart: LineChart

  init {
    inflate(context, R.layout.coin_details_view, this)
    progressBar = findViewById(R.id.progressBar)
    chart = findViewById(R.id.chart)
  }

  override fun hideLoading() {
    progressBar.visibility = View.GONE
  }

  override fun showLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun getView(): View {
    return this
  }


  override fun showErrorLoadingCoinList() {
    val container = getView().findViewById(R.id.placeSnackBar) as ViewGroup
    Snackbar.make(container
        , R.string.onErrorLoad, Snackbar.LENGTH_LONG)
        .show()
  }

  override fun showCoinDetails(result: Coin) {
    Log.println(Log.ASSERT, "coin", "tu")
  }

  override fun showCoinHistorical(historical: List<Historical>) {
    val entries = ArrayList<Entry>()

    // for (data in historical) {

    entries.add(Entry(1f, 4f))
    entries.add(Entry(2f, 3f))
    entries.add(Entry(3f, 6f))
    //}

    val dataSet = LineDataSet(entries, "Label")
    val lineData = LineData(dataSet)
    chart.data = lineData
    chart.invalidate()

  }


}