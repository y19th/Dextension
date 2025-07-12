# Dextension

[![Kotlin](https://img.shields.io/badge/kotlin-2.2.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

**Dextension** is a Kotlin library that extends [Decompose](https://github.com/arkivanov/Decompose) functionality 
for building multiplatform applications with better developer experience and single architecture.

## Key Features

- 📦 **Enhanced Components** – Simplified building blocks for UI logic
- 🛠 **Improved API** – Extension functions and utilities for Decompose
- 🌐 **Multiplatform** – Full support for all Decompose target platforms
- 🔄 **Reactive Models** – Streamlined state and event management

## Architecture

Here you can find example of constructing architecture around Dextension for Authenticate Feature Module.

![dextension drawio](https://github.com/user-attachments/assets/949e1648-e185-4bbe-9ce7-c03d3baa8916)

![dextension-component drawio](https://github.com/user-attachments/assets/d535bd7f-0a7d-475e-87e7-732bf1f35d4c)

![dextension-navigation drawio](https://github.com/user-attachments/assets/8f9e44aa-7ce5-425d-8a5a-eccf0d998ff0)

In summary, with Dextension library you building a Screens tree like this:

![dextension-tree drawio](https://github.com/user-attachments/assets/f9643217-b2ca-4767-9024-b7cc980a10cc)

## Core

Core module providing you main components of Dextension Architecture:

- Navigation Component - Contains and holding configuration navigation stack.
- ScreenComponent - The main component, used for single feature module. In MVI architecture it is ViewModel.
- EventComponent - Inherited from ScreenComponent, but without state.
- StateComponent - Inherited from ScreenComponent, but without events.
- ScreenWithEffectComponent - Expand ScreenComponent and provides side effects for communication with UI.

For navigation you can find [BaseNavigator](https://github.com/y19th/Dextension/blob/master/dextension-core/src/commonMain/kotlin/com/y19th/dextension/core/BaseNavigator.kt), which is abstraction with navigation stack.

You can find samples for Navigation and Screen components in [sample directory](https://github.com/y19th/Dextension/tree/master/dextension-core/src/commonMain/kotlin/com/y19th/dextension/core/sample).

Add the dependency to your `build.gradle.kts`:

```kotlin
sourceSets {
    commonMain {
        dependencies {
            implementation("io.github.y19th:dextension-core:<version>")
        }
    }
}
```

## Compose

Compose module providing you ability to use Dextension components with Jetpack Compose(and Compose Multiplatform).

The main component of this module is abstraction of [Screen](https://github.com/y19th/Dextension/blob/master/dextension-compose/src/commonMain/kotlin/com/y19th/dextension/compose/Screen.kt). It must be the only one thing what you can share between feature modules. Also this module provides some extensions for better usage experience like [SubscribedEffect](https://github.com/y19th/Dextension/blob/master/dextension-compose/src/commonMain/kotlin/com/y19th/dextension/compose/ScreenWithEffectComponentExtension.kt) or [collectAsImmediateState](https://github.com/y19th/Dextension/blob/master/dextension-compose/src/commonMain/kotlin/com/y19th/dextension/compose/State.kt).

Add the dependency to your `build.gradle.kts`:

```kotlin
sourceSets {
    commonMain {
        dependencies {
            implementation("io.github.y19th:dextension-compose:<version>")
        }
    }
}
```

## Extensions

Extensions module providing features, that cant be in core or compose modules.

It providing [Scheduler](https://github.com/y19th/Dextension/blob/master/dextension-extensions/src/commonMain/kotlin/com/y19th/dextension/extensions/coroutine/Scheduler.kt) interface and it's base implementation [Coroutine Scheduler](https://github.com/y19th/Dextension/blob/master/dextension-extensions/src/commonMain/kotlin/com/y19th/dextension/extensions/coroutine/CoroutineScheduler.kt), that may help you to schedule some code and repeat it with delay.

It also providing useful coroutine extensions, that allow you to manipulate with CoroutineDispatcher. For example [onLimitedDefault](https://github.com/y19th/Dextension/blob/master/dextension-extensions/src/commonMain/kotlin/com/y19th/dextension/extensions/coroutine/CoroutineExtensions.kt) function, which is taking CoroutineScope as receiver and starting coroutine on Dispatcher.Default with applied limitedParallelism(1).

Add the dependency to your `build.gradle.kts`:

```kotlin
sourceSets {
    commonMain {
        dependencies {
            implementation("io.github.y19th:dextension-extensions:<version>")
        }
    }
}
```

## Koin

Directly providing koin support for all Dextension components. In this module you have Koin + base name of component or screen, which providing KoinComponent.

Also here you have useful extensions for providing component or screen directly from koin. For example [getComponent](https://github.com/y19th/Dextension/blob/master/dextension-koin/src/commonMain/kotlin/com/y19th/dextension/koin/ComponentExtensions.kt) function, that inject component dependency without boilerplate code.

Add the dependency to your `build.gradle.kts`:

```kotlin
sourceSets {
    commonMain {
        dependencies {
            implementation("io.github.y19th:dextension-koin:<version>")
        }
    }
}
```
# Integration

If you want to integrate this library into your project, you should install [Dextension Template Plugin](https://github.com/y19th/DextensionTemplates), which improving Dextension usage experience and allows you to write components much faster and easier.

# Templates

You can find in [sample](https://github.com/y19th/Dextension/tree/master/sample/src/commonMain/kotlin/com/y19th/dextension) module.

