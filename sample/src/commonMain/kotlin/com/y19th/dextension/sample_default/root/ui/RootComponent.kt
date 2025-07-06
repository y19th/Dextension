package com.y19th.dextension.sample_default.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import com.y19th.dextension.koin.components.KoinNavigationComponent
import com.y19th.dextension.koin.getScreen
import com.y19th.dextension.sample_default.end.ui.EndScreen
import com.y19th.dextension.sample_default.navigator.MainConfiguration
import com.y19th.dextension.sample_default.navigator.MainNavigator
import com.y19th.dextension.sample_default.root.ui.RootComponent.Child.End
import com.y19th.dextension.sample_default.root.ui.RootComponent.Child.Slot
import com.y19th.dextension.sample_default.root.ui.RootComponent.Child.Start
import com.y19th.dextension.sample_default.start.ui.StartScreen
import com.y19th.dextension.sample_slot.holder.ui.SampleSlotHolderScreen

internal class RootComponent(
    componentContext: ComponentContext,
    navigator: MainNavigator
) : KoinNavigationComponent(componentContext) {

    val stack = childStack(
        source = navigator.navigation,
        handleBackButton = true,
        serializer = MainConfiguration.serializer(),
        initialConfiguration = MainConfiguration.Slot,
        childFactory = ::createChild
    )

    private fun createChild(
        configuration: MainConfiguration,
        componentContext: ComponentContext
    ): Child = when (configuration) {
        MainConfiguration.Start -> {
            Start(getScreen(componentContext))
        }

        MainConfiguration.End -> {
            End(getScreen(componentContext))
        }

        MainConfiguration.Slot -> {
            Slot(getScreen(componentContext))
        }
    }

    sealed class Child {

        data class Start(val screen: StartScreen) : Child()

        data class End(val screen: EndScreen) : Child()

        data class Slot(val screen: SampleSlotHolderScreen): Child()
    }
}