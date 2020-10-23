# Architecture
The architecture of the app is based on clean architecture, Google's MVVM with a simple MVI taste.

A simple flow of data/input is as follows:

![The architectural layers](/architecture.png "The architectural layers")

# Modules
The project is modular to decouple the logic as much as possible:

### domain
This module contains the `UseCase`s of the app and the definition of domain layer models.
This module has no dependency to any other module or any third party library (with the exception of Kotlin coroutines).

All other modules are depending on this module, this way the third party library objects and code wouldn't leak in
other parts of the project, making it easy to remove and change them in future.

### data
This module is only dependant on domain and has the implementation of repositories and the business logic.

### persistence
This module is dependant only data to implement the local data sources
and has the database layer database layer third party libraries like Room.

### Network
This module is dependant only data to implement the remote data sources
and has the database layer database layer third party libraries like Retrofit.

### presentation
The common code between ui modules is in this module and is shared between them.

### ui-***
This is a ui module that has a host activity with some fragments inside.
Each ui-*** module only depends on `presentation` module and `domain`,
this way the `Room` and `Retrofit` are not even accessible on view layer!
The `ViewModels`s are also here. Each ViewModel will expose the ui state using a single `LiveData`.

### app
This is the module that has access to all other modules to build the project and mostly contains of
dependency injection logic.