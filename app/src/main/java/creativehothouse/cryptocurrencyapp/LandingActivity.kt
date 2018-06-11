package creativehothouse.cryptocurrencyapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import creativehothouse.cryptocurrencyapp.portfolio.PortfolioFragment
import creativehothouse.cryptocurrencyapp.prices.PricesFragment

class LandingActivity : AppCompatActivity() {
  private val pricesFragment: Fragment
  private val portfolioFragment: Fragment
  lateinit var toolbar: Toolbar

  init {
    pricesFragment = PricesFragment.newInstance()
    portfolioFragment = PortfolioFragment.newInstance()
  }

  private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_list -> {
        toolbar.title = getString(R.string.item_list)
        openFragment(pricesFragment)
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_portfolio -> {
        toolbar.title = getString(R.string.item_portfolio)
        openFragment(portfolioFragment)
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setSupportActionBar(findViewById(R.id.appToolbar))
    toolbar = findViewById(R.id.appToolbar)
    val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
    bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    openFragment(pricesFragment)
  }

  private fun openFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
  }
}
