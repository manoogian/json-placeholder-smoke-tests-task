
### README.md


# API Testing Project

This project contains functional automation tests for the REST API at [JSONPlaceholder](https://jsonplaceholder.typicode.com/).

## Project Structure

```



api-testing
├── pom.xml
├── src
│   ├── main
│   │    ├── java
│   │    │    └──  JsonPlaceholder
│   │    │           ├── api
│   │    │           │    ├── ApiManager
│   │    │           │    ├── Helper
│   │    │           │    ├── Requests
│   │    │           │    ├── Validator
│   │    │           └── model
│   │    │               └── user
│   │    └──  resources
│   │         ├── postJson.json
│   │         └── postSchema.json
│   └── test
│       ├── java
│       │    └── JsonPlaceholder
│       │        └── SmokeTest
│       └── resources
│           ├── testing.xml
│           └── ApiTest.java
└── README.md


```



## Test Details

The `ApiTest.java` file contains the test cases. The tests perform the following actions:

1. Fetch a list of users and print the email address of the first user.
2. Fetch the posts of the first user and verify that the Post IDs are between 1 and 100.
3. Create a new post for the first user and verify that the response contains the correct title, body, and userID.

## Test Scenario

### Scenario: Fetch and verify user details and posts, then create a new post

#### Steps:

1. **Get a Random User:**
   - Send a GET request to `/users`.
   - Extract the ID and email address of the first user in the response.
   - Print the user's email address to the console.

2. **Verify User's Posts:**
   - Using the extracted userID, send a GET request to `/posts?userId={userID}`.
   - Verify that each post ID in the response is an integer between 1 and 100.

3. **Create a New Post:**
   - Using the same userID, send a POST request to `/posts` with a JSON body containing:
      - A non-empty title.
      - A non-empty body.
   - Verify that the response contains:
      - The correct userID.
      - The correct title.
      - The correct body.
   - Ensure the response status code is `201 Created`.

#### Expected Results:
- The email address of the first user is printed to the console.
- All post IDs associated with the user are valid integers between 1 and 100.
- A new post is successfully created with the correct details, and the API returns the expected response.

## Setup

This project uses Maven for dependency management.

### Prerequisites

- Java 8 or higher
- Maven

### Dependencies

- RestAssured: For making HTTP requests and assertions.
- testng: For running the tests.
- JsonPlaceholder
- json-simple
- json
## Clone the repository

   ```sh
    git@github.com:manoogian/json-placeholder-smoke-tests-task.git