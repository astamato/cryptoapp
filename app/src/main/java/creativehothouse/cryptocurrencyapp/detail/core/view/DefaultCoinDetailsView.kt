package creativehothouse.cryptocurrencyapp.detail.core.view

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.jakewharton.rxbinding2.view.clicks
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.detail.model.Historical
import io.reactivex.Observable


class DefaultCoinDetailsView(context: Context?) : CoinDetailsView, LinearLayout(context) {

  private var progressBar: ProgressBar
  private var chart: LineChart
  private var toolbar: Toolbar
  private var addToPortfolioButton: Button

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
    addToPortfolioButton.isEnabled = true
  }

  override fun observeAddToPortfolioClicks(): Observable<Unit> {
    return addToPortfolioButton.clicks()
  }

}