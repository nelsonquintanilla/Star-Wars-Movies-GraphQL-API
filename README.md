# Ravn-Challenge-V2-Nelson-Quintanilla

## Project description
* Android app that uses the Star Wars GraphQL API to load a list of all the characters from Star Wars movies. For each item on the list it also has a detailed view that shows more details of the character, such as eye color, hair color, skin color, birth year, and vehicles asociated with them. 

* The project follows the Clean Architecture pattern and is comprised of 3 main modules: app, which contains everything relating the views; data, which contains everything regarding the networking of the application; and domain, wich contains the use cases and models used in the views.

* Endpoint used: https://swapi-graphql.netlify.app/.netlify/functions/index

* Query utilized: 

```
query PeopleList($size: Int, $cursor: String) {
  allPeople(first: $size, after: $cursor) {
    people {
      id
      name
      eyeColor
      hairColor
      skinColor
      birthYear
      species {
        id
        name
      }
      homeworld {
        id
        name
      }
      vehicleConnection {
        vehicles {
          id
          name
        }
      }
    }
    pageInfo {
      hasNextPage
      hasPreviousPage
      startCursor
      endCursor
    }
  }
}
```

## Running instructions (Android Studio version 3.4 or newer is needed).
* Clone the repo. In the main branch is the final code version. There is also the develpo branch which was use to merge the features as the project was being developed.

* Android Studio will take some time to index the contents of the project. If the project gives you problems because it does not generates the PeopleListQuery file, please try Clean Project, then Make Project, and then Run Project. 

* Run the project.

  * If the query inside PeopleList.graphql is modified, the project needs to be compiled before running it to generate the code inside the PeopleListQuery file that is used to make the request with the GraphQl client.

## Technologies used
- [Material Components](https://github.com/material-components/material-components-android)
- [Apache Commons](https://commons.apache.org/proper/commons-text/) - For string formatting (capitalizing).
- [Koin](https://github.com/InsertKoinIO/koin)
- [Kotlin coroutines]()
- Architecture Components:
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
  - [VIewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
  - [Navigation Component](https://developer.android.com/topic/libraries/architecture/viewmodel)
    - [Safe Args]()
  - [Data Binding Library](https://developer.android.com/topic/libraries/data-binding)
- [Apollo Android](https://www.apollographql.com/docs/android/)
- [Retrofit](https://github.com/square/retrofit)

## Gif of the working application
![](https://media.giphy.com/media/wZ4U9DV3tlopqagBkL/giphy.gif)
