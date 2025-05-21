package com.y19th.dextension.koin.components

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.BaseComponent
import com.y19th.dextension.core.BaseEffects
import com.y19th.dextension.core.BaseEvents
import com.y19th.dextension.core.BaseState
import com.y19th.dextension.core.EventComponent
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.core.ScreenWithEffectComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import org.koin.core.component.KoinComponent

abstract class KoinBaseComponent(
    componentContext: ComponentContext,
    coroutineExceptionHandler: CoroutineExceptionHandler? = null
) : KoinComponent, BaseComponent(
    componentContext = componentContext,
    coroutineExceptionHandler = coroutineExceptionHandler
)

abstract class KoinScreenComponent<State : BaseState, in Event : BaseEvents>(
    componentContext: ComponentContext,
    initialState: State
) : KoinComponent, ScreenComponent<State, Event>(
    componentContext = componentContext,
    initialState = initialState
)

abstract class KoinEventComponent<Event : BaseEvents>(
    componentContext: ComponentContext
) : KoinComponent, EventComponent<Event>(
    componentContext = componentContext
)

abstract class KoinScreenWithEffectComponent<State : BaseState, Events : BaseEvents, Effect : BaseEffects>(
    componentContext: ComponentContext,
    initialState: State
) : KoinComponent, ScreenWithEffectComponent<State, Events, Effect>(
    componentContext = componentContext,
    initialState = initialState
)