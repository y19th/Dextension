package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext

/**
 * [ScreenComponent] with [EmptyState] instance.
 *
 * Used when you have not state at all.
* */
abstract class EventComponent<Event: BaseEvents>(
    componentContext: ComponentContext
): ScreenComponent<BaseState, Event>(
    componentContext = componentContext,
    initialState = EmptyState.Empty
)