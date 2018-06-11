package creativehothouse.cryptocurrencyapp.prices

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import creativehothouse.cryptocurrencyapp.app.builder.NetworkModule
import creativehothouse.cryptocurrencyapp.prices.builder.DaggerPricesComponent
import creativehothouse.cryptocurrencyapp.prices.builder.PricesModule
import creativehothouse.cryptocurrencyapp.prices.core.presenter.PricesPresenter
import javax.inject.Inject

class PricesFragment : Fragment() {

  @Inject
  lateinit var presenter: PricesPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DaggerPricesComponent.builder().pricesModule(PricesModule(context!!))
        .networkModule(NetworkModule(context!!)).build()
        .inject(this)

    presenter.create()
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return presenter.getView()
  }

  companion object {
    fun newInstance(): PricesFragment = PricesFragment()
  }
}