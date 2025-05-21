package com.y19th.dextension.sample_default.navigator

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront

internal class MainNavigatorImpl : MainNavigator {
    override fun toEnd() {
        handleConfiguration(MainConfiguration.End)
    }

    override fun toStart() {
        handleConfiguration(MainConfiguration.Start)
    }

    override val navigation: StackNavigation<MainConfiguration> = StackNavigation()

    override fun handleConfiguration(configuration: MainConfiguration) {
        navigation.bringToFront(configuration)
    }
}