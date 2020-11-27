# Jackson JSON API

[![Build](https://github.com/michaelruocco/jackson-json-api/workflows/pipeline/badge.svg)](https://github.com/michaelruocco/jackson-json-api/actions)
[![codecov](https://codecov.io/gh/michaelruocco/jackson-json-api/branch/master/graph/badge.svg)](https://codecov.io/gh/michaelruocco/jackson-json-api)
[![BCH compliance](https://bettercodehub.com/edge/badge/michaelruocco/jackson-json-api?branch=master)](https://bettercodehub.com/)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/082023bfbd484b058a24eca04b215572)](https://www.codacy.com/manual/michaelruocco/jackson-json-api?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=michaelruocco/jackson-json-api&amp;utm_campaign=Badge_Grade)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_jackson-json-api&metric=alert_status)](https://sonarcloud.io/dashboard?id=michaelruocco_jackson-json-api)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_jackson-json-api&metric=sqale_index)](https://sonarcloud.io/dashboard?id=michaelruocco_jackson-json-api)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_jackson-json-api&metric=coverage)](https://sonarcloud.io/dashboard?id=michaelruocco_jackson-json-api)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=michaelruocco_jackson-json-api&metric=ncloc)](https://sonarcloud.io/dashboard?id=michaelruocco_jackson-json-api)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/jackson-json-api/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.michaelruocco/jackson-json-api)
[![JCenter](https://api.bintray.com/packages/michaelruocco/maven/jackson-json-api/images/download.svg) ](https://bintray.com/michaelruocco/maven/jackson-json-api/_latestVersion)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

This is a java library that aims at handling most of the boilerplate code
that is required if you are using the JSON API specification when building
your APIs.

## Usage

To use the library you will need to add a dependency to your project. In
gradle you would do this by adding the following to your build.gradle file:

```gradle
dependencies {
    compile 'com.github.michaelruocco:jackson-json-api:{latest-version}'
}
```

## Useful Commands

```gradle
// cleans build directories
// prints currentVersion
// checks dependency versions
// formats code
// builds code
// runs unit tests
./gradlew clean currentVersion dependencyUpdates spotlessApply lintGradle build
```