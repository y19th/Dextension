package com.y19th.dextension.core.sample

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.y19th.dextension.core.BaseNavigator
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

/**
* Must be serialized
* */
internal sealed class Configuration {
    data object Foo : Configuration()

    data object Bar : Configuration()

    companion object {
        fun serializer(): KSerializer<Configuration> {
            TODO()
        }
    }
}

internal class SampleNavigator : BaseNavigator<Configuration> {
    override val navigation: StackNavigation<Configuration> = StackNavigation()

    override fun handleConfiguration(configuration: Configuration) {
        navigation.bringToFront(configuration)
    }
}