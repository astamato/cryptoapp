package creativehothouse.cryptocurrencyapp.detail.core.view

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.jakewharton.rxbinding2.view.clicks
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.detail.core.utils.DateAxisValueFormatter
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.Date


class DefaultCoinDetailsView(context: Context?) : CoinDetailsView, CoordinatorLayout(context) {

  private var progressBar: ProgressBar
  private var chart: LineChart
  private var toolbar: Toolbar
  private var addToPortfolioButton: FloatingActionButton

  init {
    inflate(context, R.layout.coin_details_view, this)
    toolbar = findViewById(R.id.appToolbar)
    toolbar.title = context?.getString(R.string.coin_details_screen)
    progressBar = findViewById(R.id.progressBar)
    chart = findViewById(R.id.chart)
    addToPortfolioButton = findViewById(R.id.addToPortfolio)

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
    activateView()
    showCoinDetails(coin)

    drawChartStrategy1(historical)

    drawChartStrategy2(historical, coin)

  }

  /**
   * Will make the view visible once the loading of the data is completed
   */
  private fun activateView() {
    var scrollView = findViewById<View>(R.id.scrollView)
    scrollView.visibility = View.VISIBLE
  }


  private fun drawChartStrategy1(historical: List<Historical>) {
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    val graph = findViewById<View>(R.id.graph) as GraphView
    val list = ArrayList<DataPoint>()
    for (hist in historical) {
      list.add(DataPoint(hist.snapshot, hist.priceUSD.toDouble()))
    }
    val series = LineGraphSeries<DataPoint>(list.toTypedArray())

    graph.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
      override fun formatLabel(value: Double, isValueX: Boolean): String {
        if (isValueX) {
          return sdf.format(Date(value.toLong()))
        }
        return super.formatLabel(value, isValueX)

      }
    }
    graph.viewport.setMinX(historical[0].snapshot.time.toDouble())
    graph.viewport.setMaxX(historical[historical.size - 1].snapshot.time.toDouble())
    graph.viewport.isXAxisBoundsManual = true
    graph.gridLabelRenderer.numHorizontalLabels = 3
    graph.addSeries(series)
  }

  private fun drawChartStrategy2(historical: List<Historical>,
      coin: Coin) {
    val entries = ArrayList<Entry>()
    val referenceTimestamp = historical[0].snapshot.time

    var xAxisFormatter = DateAxisValueFormatter(referenceTimestamp)
    var xAxis = chart.xAxis
    xAxis.valueFormatter = xAxisFormatter

    for (data in historical) {
      entries.add(Entry((data.snapshot.time - referenceTimestamp).toFloat(), data.priceUSD.toFloat()))
    }

    val dataSet = LineDataSet(entries, coin.name)
    val lineData = LineData(dataSet)
    chart.data = lineData

    val description = Description()
    description.text = "Historical evolution of Cryptocoin"
    chart.description = description
    chart.invalidate()
  }

  private fun showCoinDetails(coin: Coin) {
    val name = findViewById<TextView>(R.id.name)
    name.text = coin.name
    val symbol = findViewById<TextView>(R.id.symbol)
    symbol.text = coin.symbol
    val currentPrice = findViewById<TextView>(R.id.currentPrice)
    currentPrice.text = coin.priceUSD
    val variation = findViewById<TextView>(R.id.variation)
    variation.text = coin.percentChange24h

    toolbar.title = coin.name
  }

  override fun displaySuccessAddToPortfolioDialog(coin: Coin, trade: Trade) {
    val alertDialog = AlertDialog.Builder(context).create()
    alertDialog.setTitle(context.getString(R.string.add_to_portfolio_dialog_title))
    alertDialog.setMessage(
        context.getString(R.string.add_to_portfolio_dialog_message, coin.name, coin.symbol, "%.2f".format(trade.amount)))
    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
        { dialog, _ -> dialog.dismiss() })
    alertDialog.show()
  }

  override fun enableAddToPortfolioButton() {
    addToPortfolioButton.visibility = View.VISIBLE
    addToPortfolioButton.isEnabled = true
  }

  override fun observeAddToPortfolioClicks(): Observable<Unit> {
    return addToPortfolioButton.clicks()
  }

}