# Cryptocurrencies Application

Main functionalities:

* Display list of supported Cryptocurrencies
* Display details of a given Cryptocurrency
* Add Cryptocurrency trade to portfolio
* Display portfolio of User


The app is written mainly in Kotlin. 
Built using MVP pattern in combination with rx binding.
This helps break the circular dependency this pattern usually has between the Presenter and the View. The presenter should 
present the view but the view should't necessarily know about the presenter.
Has a Bottom Navigation View and 2 main fragments.
Some classes are similar which is intentional. Each screen is treated as a separate independent micro component that's able to 
fulfill all its dependencies and does not rely on a core module with shared code.
Injection of dependencies is driven by Dagger 2.

2 libraries were introduced to resolve the historical graph in the coin details view. In a real world scenario I'd present 
options to the designers to see wha t 

Still TODO:

* Prices view list, infinite scrolling
* Persistence with Realm for portfolio screen
* Fulfill name and symbol from bitcoins from persisted data to the portfolio view
* Better UI design
* Unit testing
* Integration tests. Automation test.

Observations
* Coin object price_usd different type than portfolio trade price_usd
* Store a new trade in the authed user portfolio all -> amount in body is float but response is string?
* Pagination of list of coins
* Realm does not support Kotlin's data classes