package creativehothouse.cryptocurrencyapp.portfolio.core.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Trade
import creativehothouse.cryptocurrencyapp.portfolio.core.view.adapter.TradePortfolioAdapter.TradeModelViewHolder


class TradePortfolioAdapter(private val trades: List<Trade>) : RecyclerView.Adapter<TradeModelViewHolder>() {

  override fun getItemCount(): Int {
    return trades.size
  }

  override fun onBindViewHolder(holder: TradeModelViewHolder, position: Int) {
    // FIXME get name and symbol
    // holder.name.text = trades[position].name
    // holder.symbol.text = trades[position].symbol
    holder.amount.text = "%.2f".format(trades[position].amount)
    holder.price.text = "%.2f".format(trades[position].priceUSD)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradeModelViewHolder {
    val trade = LayoutInflater.from(parent.context)
        .inflate(getLayoutToInflate(), parent, false)

    return TradeModelViewHolder(trade)
  }

  private fun getLayoutToInflate(): Int {
    return R.layout.trade_coin_item
  }


  inner class TradeModelViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val name = itemView.findViewById(R.id.name) as TextView
    val symbol = itemView.findViewById(R.id.symbol) as TextView
    val amount = itemView.findViewById(R.id.amount) as TextView
    val price = itemView.findViewById(R.id.price) as TextView

  }

}
