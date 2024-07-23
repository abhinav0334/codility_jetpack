Introduction
This application is the demo project of using the apis with the MVVM structure and solid principles.

Features
These are key features of your Android application:

1. Using the HiltViewModel in the project
2. Using the Models classes for parsing the response

Architecture
MVVM (Model-View-ViewModel)
MVVM is used to separate the UI logic from the business logic and to maintain a clear separation of concerns.

Hilt Dependency Injection
Hilt is used for dependency injection to facilitate modularization and easier unit testing by providing a way to manage dependencies in a consistent and reusable way.

Repositories
Repositories are used to abstract the data sources from the rest of the application. They provide a clean API for data access to the ViewModel layer, enabling separation of concerns and easier testing.

Dependencies
* Android Jetpack components (e.g ViewModel, LiveData)
* Hilt
* Retrofit
* Recyclerview
* Mockito

Testing
Unit test cases are written