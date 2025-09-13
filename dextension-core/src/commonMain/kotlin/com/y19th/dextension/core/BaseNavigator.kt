package com.y19th.dextension.core

import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.pop

/**
 * Interface for all navigators that contains default navigator's functions:
 *
 * - [navigation] handles navigation stack.
 * - [pop] optional function used for pop stack.
 * - [handleConfiguration] main function used for transforming navigation stack.
 *
 * Sample usage:
 * @sample com.y19th.dextension.core.sample.SampleNavigator
 * */
interface BaseNavigator<Configuration : Any> {

    val navigation: StackNavigation<Configuration>

    fun pop() {
        navigation.pop()
    }

    fun modifyStack(block: (List<Configuration>) -> List<Configuration>) =
        navigation.navigate(block)

    fun handleConfiguration(configuration: Configuration)
}