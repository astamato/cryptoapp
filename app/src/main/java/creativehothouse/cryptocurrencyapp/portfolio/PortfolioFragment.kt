package creativehothouse.cryptocurrencyapp.portfolio

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.portfolio.builder.DaggerPortfolioComponent
import creativehothouse.cryptocurrencyapp.portfolio.builder.PortfolioModule
import creativehothouse.cryptocurrencyapp.portfolio.core.presenter.PortfolioPresenter
import javax.inject.Inject

class PortfolioFragment : Fragment() {

  @Inject
  lateinit var presenter: PortfolioPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerPortfolioComponent.builder().portfolioModule(PortfolioModule(context!!))
        .networkModule(NetworkModule(context!!)).build()
        .inject(this)

    presenter.create()
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return presenter.getView()
  }

  companion object {
    fun newInstance(): PortfolioFragment = PortfolioFragment()
  }
}