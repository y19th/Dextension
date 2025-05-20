package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext

abstract class StateComponent<State: BaseState>(
    componentContext: ComponentContext,
    initialState: State
): ScreenComponent<State, Nothing>(
    componentContext = componentContext,
    initialState = initialState
) {
    override fun handleEvent(event: Nothing) = Unit
}