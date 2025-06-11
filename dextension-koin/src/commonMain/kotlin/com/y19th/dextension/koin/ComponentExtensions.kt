package com.y19th.dextension.koin

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

/**
 * Koin wrapper for getting component from koin graph. You need to provide component to graph by your own.
 * Used for components without parameters.
 * */
inline fun <reified Component : Any> KoinComponent.getComponent(context: ComponentContext): Component {
    return get<Component> { parametersOf(context) }
}

/**
 * Koin wrapper for getting component from koin graph. You need to provide component to graph by your own.
 * Used for components without parameters.
 *
 * @param params vararg parameters that will be injected into component.
 * */
inline fun <reified Component : Any, T : Any> KoinComponent.getComponent(
    context: ComponentContext,
    vararg params: T
): Component {
    return get<Component> { parametersOf(context, *params) }
}

/**
 * Koin wrapper for getting component from koin graph. You need to provide component to graph by your own.
 *
 * @param param single parameters that will be injected into component.
 * */
inline fun <reified Component : Any, T : Any> KoinComponent.getComponent(
    context: ComponentContext,
    param: T
): Component {
    return get<Component> { parametersOf(context, param) }
}

/**
 * Koin wrapper for getting component from koin graph. You need to provide component to graph by your own.
 *
 * @param qualifier koin qualifier for component
 * */
inline fun <reified Component : Any> KoinComponent.getComponent(
    context: ComponentContext,
    qualifier: Qualifier
): Component {
    return get<Component>(qualifier = qualifier) { parametersOf(context) }
}