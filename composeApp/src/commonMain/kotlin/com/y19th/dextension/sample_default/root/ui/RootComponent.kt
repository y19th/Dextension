package com.y19th.dextension.sample_default.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.dextension.core.BaseComponent
import com.y19th.dextension.koin.getComponent
import com.y19th.dextension.sample_default.end.ui.EndScreen
import com.y19th.dextension.sample_default.navigator.MainConfiguration
import com.y19th.dextension.sample_default.navigator.MainNavigator
import com.y19th.dextension.sample_default.start.ui.StartScreen

internal class RootComponent(
    componentContext: ComponentContext,
    navigator: MainNavigator
) : BaseComponent(componentContext) {

    val stack = childStack(
        source = navigator.navigation,
        handleBackButton = true,
        serializer = MainConfiguration.serializer(),
        initialConfiguration = MainConfiguration.StartConfiguration,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: MainConfiguration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        MainConfiguration.StartConfiguration -> {
            Child.Start(getComponent(componentContext))
        }

        MainConfiguration.EndConfiguration -> {
            Child.End(getComponent(componentContext))
        }
    }

    sealed class Child {

        data class Start(val screen: StartScreen) : Child()

        data class End(val screen: EndScreen) : Child()
    }
}