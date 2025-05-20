package com.y19th.dextension.koin

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.compose.Screen
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier


inline fun <reified T : Screen> KoinComponent.getScreen(context: ComponentContext): T {
    return get<T> { parametersOf(context) }
}

inline fun <reified T : Screen> KoinComponent.getScreen(
    context: ComponentContext,
    vararg params: Any
): T {
    return get<T> { parametersOf(context, *params) }
}

inline fun <reified T : Screen> KoinComponent.getScreen(
    context: ComponentContext,
    qualifier: Qualifier
): T {
    return get<T>(qualifier = qualifier) { parametersOf(context) }
}