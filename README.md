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
List of coins is loaded in a paginated way in relation to REST API.
* Persistence with Realm for portfolio screen

TODO:
* List of prices, variations with colours, negative in red, positive in green.
* In case of no internet, banner indicated last updated timestamp for portfolio
* refresh buttons and pull to refresh
* Persistence of main list of Coins ids, name and symbol.
* Fulfill name and symbol from bitcoins from persisted data to the portfolio view
* Improve UI design
* Unit testing

* Integration tests. Automation test.

Observations
* Coin object price_usd different type than portfolio trade price_usd
* Store a new trade in the authed user portfolio all -> amount in body is float but response is string?
* Store a new trade in the authed user portfolio put call does not store the data
* Realm does not support Kotlin's data classes