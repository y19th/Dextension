package com.y19th.dextension.core.sample

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.dextension.core.NavigationComponent
import com.y19th.dextension.core.ScreenComponent

internal class SampleNavigationComponent(
    sampleNavigator: SampleNavigator,
    componentContext: ComponentContext
) : NavigationComponent(componentContext) {

    val stack = childStack(
        source = sampleNavigator.navigation,
        initialConfiguration = Configuration.Bar,
        serializer = Configuration.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: Configuration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        Configuration.Bar -> TODO()
        Configuration.Foo -> TODO()
    }


    sealed class Child {

        data class Foo(val instance: ScreenComponent<*, *>) : Child()

        data class Bar(val instance: ScreenComponent<*, *>) : Child()
    }
}