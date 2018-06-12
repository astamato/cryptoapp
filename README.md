# Cryptocurrencies Application

Main functionalities:

* Display list of supported Cryptocurrencies
* Display details of a given Cryptocurrency
* Add Cryptocurrency to portfolio
* Display portfolio of User


The app is written mainly in Kotlin. 
Built using MVP pattern in combination with rx binding.
Has a Bottom Navigation View and 2 main fragments.
This helps break the circular dependency this pattern usually has between the Presenter and the View. The presenter should 
present the view but the view should't necessarily know about the presenter.
Some classes are similar which is intentional. Each screen is treated as a separate independent micro component that's able to 
fulfill all its dependencies and does not rely on a core module with shared code.

Still TODO:

* Historical graph for coins history and evolution
* Persistance with Realm for portfolio screen
* Adding add cryptocurrencies to portfolio from details view
* Fulfill name and symbol from bitcoins from persisted data
* Better UI design
* Unit testing
* Integration tests. Automation test