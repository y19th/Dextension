package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.util.componentCoroutineContext
import com.y19th.dextension.core.util.defaultCoroutineScope
import kotlinx.coroutines.CoroutineScope

/**
 * Handles navigation stack and child factory. Using as root component of feature module.
 *
 * @sample com.y19th.dextension.core.sample.SampleNavigationComponent
 * */
abstract class NavigationComponent(
    componentContext: ComponentContext
) : BaseComponent, ComponentContext by componentContext {

    override val scope: CoroutineScope = defaultCoroutineScope(
        context = componentCoroutineContext()
    )
}