package creativehothouse.cryptocurrencyapp.prices.core.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jakewharton.rxbinding2.view.clicks
import creativehothouse.cryptocurrencyapp.R
import creativehothouse.cryptocurrencyapp.app.model.Coin
import creativehothouse.cryptocurrencyapp.prices.core.view.adapter.CoinsPricesAdapter.CoinModelViewHolder
import io.reactivex.subjects.PublishSubject


class CoinsPricesAdapter(private val coins: ArrayList<Coin>) : RecyclerView.Adapter<CoinModelViewHolder>() {
  val clickCoinEvent = PublishSubject.create<Coin>()!!

  override fun getItemCount(): Int {
    return coins.size
  }


  fun addToCoins(moreCoins: List<Coin>) {
    val previousSize = coins.size
    coins.addAll(moreCoins)
    notifyItemRangeInserted(previousSize, moreCoins.size)
  }

  override fun onBindViewHolder(holder: CoinModelViewHolder, position: Int) {
    holder.name.text = coins[position].name
    holder.symbol.text = holder.symbol.context.getString(R.string.trades_viewholder_symbol_format, coins[position]
        .symbol)
    holder.currentPrice.text = coins[position].priceUSD
    holder.variation.text = coins[position].percentChange24h
    holder.rank.text =
        holder.symbol.context.getString(R.string.rank_format, coins[position]
            .rank.toString())
    coins[position].rank.toString()

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinModelViewHolder {
    val ticket = LayoutInflater.from(parent.context)
        .inflate(getLayoutToInflate(), parent, false)

    return CoinModelViewHolder(ticket)
  }

  private fun getLayoutToInflate(): Int {
    return R.layout.prices_coin_item
  }

  inner class CoinModelViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    init {
      itemView.clicks().map { coins[layoutPosition] }.subscribe(clickCoinEvent)
    }

    val name = itemView.findViewById(R.id.name) as TextView
    val symbol = itemView.findViewById(R.id.symbol) as TextView
    val currentPrice = itemView.findViewById(R.id.currentPrice) as TextView
    val variation = itemView.findViewById(R.id.variation) as TextView
    val rank = itemView.findViewById(R.id.rank) as TextView

  }

}
