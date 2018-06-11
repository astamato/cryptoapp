package creativehothouse.cryptocurrencyapp.portfolio

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import creativehothouse.cryptocurrencyapp.R

class PortfolioFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
      inflater.inflate(R.layout.fragment_portfolio, container, false)

  companion object {
    fun newInstance(): PortfolioFragment = PortfolioFragment()
  }
}