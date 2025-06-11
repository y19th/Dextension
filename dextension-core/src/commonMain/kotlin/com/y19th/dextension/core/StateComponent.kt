package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext

/**
* [ScreenComponent] with [Nothing] as events.
 *
 * Used when you have not events at all.
* */
abstract class StateComponent<State: BaseState>(
    componentContext: ComponentContext,
    initialState: State
): ScreenComponent<State, Nothing>(
    componentContext = componentContext,
    initialState = initialState
) {
    override fun handleEvent(event: Nothing) = Unit
}