package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext

abstract class EventComponent<Event: BaseEvents>(
    componentContext: ComponentContext
): ScreenComponent<BaseState, Event>(
    componentContext = componentContext,
    initialState = EmptyState.Empty
)