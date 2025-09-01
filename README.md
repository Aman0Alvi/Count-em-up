# Count'em Up (Java)

<img width="374" height="263" alt="image" src="https://github.com/user-attachments/assets/28730b1c-ae89-4c40-9954-0d3821176c95" />

You can find the instructions for this lab [here](https://morethanequations.com/Computer-Science/Labs/Count'em-Up). Create a new repository on GitHub to house your code. Be sure to make the repository public so that I can view and grade it.

We will use [Gradle](https://gradle.org/) to automate common development tasks.

## Building the App

You can build the app using:

```bash
./gradlew build
```

## Testing the App

You can run the automated suite of tests using:

```bash
./gradlew test
```

## Running the App

You can run the app using:

```bash
./gradlew run --quiet --console=plain
```

The two flags passed to the `run` command hide the noisy output from Gradle. You can see the details from Gradle by omitting those flags.
