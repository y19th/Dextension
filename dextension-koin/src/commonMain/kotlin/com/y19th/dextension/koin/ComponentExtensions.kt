package com.y19th.dextension.koin

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

inline fun <reified Component : Any> KoinComponent.getComponent(context: ComponentContext): Component {
    return get<Component> { parametersOf(context) }
}

inline fun <reified Component : Any, T : Any> KoinComponent.getComponent(
    context: ComponentContext,
    vararg params: T
): Component {
    return get<Component> { parametersOf(context, *params) }
}

inline fun <reified Component : Any, T : Any> KoinComponent.getComponent(
    context: ComponentContext,
    param: T
): Component {
    return get<Component> { parametersOf(context, param) }
}

inline fun <reified Component : Any> KoinComponent.getComponent(
    context: ComponentContext,
    qualifier: Qualifier
): Component {
    return get<Component>(qualifier = qualifier) { parametersOf(context) }
}