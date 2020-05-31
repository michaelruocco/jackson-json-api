# Jackson JSON API

[![Build Status](https://travis-ci.org/michaelruocco/jackson-json-api.svg?branch=master)](https://travis-ci.org/michaelruocco/jackson-json-api)
[![codecov](https://codecov.io/gh/michaelruocco/jackson-json-api/branch/master/graph/badge.svg)](https://codecov.io/gh/michaelruocco/jackson-json-api)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/jackson-json-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/jackson-json-api)
[![JCenter](https://api.bintray.com/packages/michaelruocco/maven/jackson-json-api/images/download.svg) ](https://bintray.com/michaelruocco/maven/jackson-json-api/_latestVersion)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/jackson-json-api?branch=master)](https://bettercodehub.com/)

This is a java library that aims at handling most of the boilerplate code
that is required if you are using the JSON API specification when building
your APIs.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```
dependencies {
    compile 'com.github.michaelruocco:jackson-json-api:{latest-version}'
}
```

## Running the Tests

You can run the unit tests for this project by running:

```
gradlew clean build
```

## Cleaning up the code

Additionally you can run a small set of code cleaning rules that will clean
up things like spacing and other minor elements by running

```
gradlew clean spotlessApply build
```

## Checking dependencies

You can check the current dependencies used by the project to see whether
or not they are currently up to date by running the following command:

```
gradlew dependencyUpdates
```