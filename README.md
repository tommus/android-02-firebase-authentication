# Firebase Authentication

## Compatibility

This application targets Android (5.0) Lollipop and newer.

## Project Modules

This project consists of the following modules:

1. **app** - produces executable client application.

## Gradle properties

Available options that can be configured in `gradle.properties` file:

  - `DefaultEmail` - allows to configure default login used under development process,
  - `DefaultPassword` - allows to configure default password used under development process,
  - `EnableCrashlytics` - allows to enable/disable default bugtracker (eg. Crashlytics),
  - `EnableStetho` - allows to enable/disable debug bridge (eg. Stetho).
  - `ReleaseStorePassword` - signing password,
  - `ReleaseKeyAlias` - signing alias,
  - `ReleaseKeyPassword` - signign password.

> Note that you can find `gradle.properties.sample` file in application modules. If you would like to use default values, just copy this file and paste as `gradle.properties`.

> File `gradle.properties` is not tracked by git so you can use sensitive data there - but use it with care!  

After preparing `gradle.properties` file you have to synchronize your Gradle build. This allows to generate `BuildConfig` class with required constant variables.
