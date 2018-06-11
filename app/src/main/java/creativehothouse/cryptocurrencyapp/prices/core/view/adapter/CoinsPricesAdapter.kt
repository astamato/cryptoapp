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


class CoinsPricesAdapter(private val coins: List<Coin>) : RecyclerView.Adapter<CoinModelViewHolder>() {
  val clickCoinEvent = PublishSubject.create<Coin>()!!

  override fun getItemCount(): Int {
    return coins.size
  }

  override fun onBindViewHolder(holder: CoinModelViewHolder, position: Int) {
    holder.description.text = coins[position].name
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

    val description = itemView.findViewById(R.id.name) as TextView

  }

}
