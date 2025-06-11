package com.y19th.dextension.koin

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.compose.Screen
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier

/**
 * Koin wrapper for getting component screen from koin graph. You need to provide screen to graph by your own.
 * Used for screens without parameters.
 * */

inline fun <reified T : Screen> KoinComponent.getScreen(context: ComponentContext): T {
    return get<T> { parametersOf(context) }
}

/**
 * Koin wrapper for getting component screen from koin graph. You need to provide screen to graph by your own.
 * Used for screens without parameters.
 *
 * @param params vararg parameters that will be injected to screen instance.
 * */
inline fun <reified T : Screen> KoinComponent.getScreen(
    context: ComponentContext,
    vararg params: Any
): T {
    return get<T> { parametersOf(context, *params) }
}

/**
 * Koin wrapper for getting component screen from koin graph. You need to provide screen to graph by your own.
 * Used for screens without parameters.
 *
 * @param param single parameter that will be injected to screen instance.
 * */
inline fun <reified T : Screen> KoinComponent.getScreen(
    context: ComponentContext,
    param: T
): T {
    return get<T> { parametersOf(context, param) }
}

/**
 * Koin wrapper for getting component screen from koin graph. You need to provide screen to graph by your own.
 * Used for screens without parameters.
 *
 * @param qualifier koin qualifier for screen.
 * */
inline fun <reified T : Screen> KoinComponent.getScreen(
    context: ComponentContext,
    qualifier: Qualifier
): T {
    return get<T>(qualifier = qualifier) { parametersOf(context) }
}