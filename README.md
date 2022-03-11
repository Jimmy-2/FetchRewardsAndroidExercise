# FetchRewardsAndroidExercise
Android coding exercise for Fetch Rewards apprenticeship application.

## Specifications: 
### Please write a native Android app in Kotlin or Java that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.
Display this list of items to the user based on the following requirements:

    Display all the items grouped by "listId"
    Sort the results first by "listId" then by "name" when displaying.
    Filter out any items where "name" is blank or null.

### Testing Instructions:
There are instrumental tests and a unit test for the app.

* Run the FetchItemServiceTests class to simulate receiving data from a mock json file.

* Run the ExampleInstrumentedTest class to test realistic delays and data loading when accessing data from an API, and to simulate a user using the app.

