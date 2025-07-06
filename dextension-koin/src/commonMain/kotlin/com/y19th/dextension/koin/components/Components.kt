package com.y19th.dextension.koin.components

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.BaseEffects
import com.y19th.dextension.core.BaseEvents
import com.y19th.dextension.core.BaseState
import com.y19th.dextension.core.EventComponent
import com.y19th.dextension.core.NavigationComponent
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.core.ScreenWithEffectComponent
import com.y19th.dextension.core.StateComponent
import org.koin.core.component.KoinComponent

/**
 * Wrapper on [NavigationComponent] with [KoinComponent].
 * */
abstract class KoinNavigationComponent(
    componentContext: ComponentContext
) : KoinComponent, NavigationComponent(
    componentContext = componentContext,
)

/**
 * Wrapper on [ScreenComponent] with [KoinComponent].
 * */
abstract class KoinScreenComponent<State : BaseState, in Event : BaseEvents>(
    componentContext: ComponentContext,
    initialState: State
) : KoinComponent, ScreenComponent<State, Event>(
    componentContext = componentContext,
    initialState = initialState
)

/**
 * Wrapper on [StateComponent] with [KoinComponent].
 * */
abstract class KoinStateComponent<State : BaseState>(
    componentContext: ComponentContext,
    initialState: State
) : KoinComponent, StateComponent<State>(
    componentContext = componentContext,
    initialState = initialState
)

/**
 * Wrapper on [EventComponent] with [KoinComponent].
 * */
abstract class KoinEventComponent<Event : BaseEvents>(
    componentContext: ComponentContext
) : KoinComponent, EventComponent<Event>(
    componentContext = componentContext
)

/**
 * Wrapper on [ScreenWithEffectComponent] with [KoinComponent].
 * */
abstract class KoinScreenWithEffectComponent<State : BaseState, Events : BaseEvents, Effect : BaseEffects>(
    componentContext: ComponentContext,
    initialState: State
) : KoinComponent, ScreenWithEffectComponent<State, Events, Effect>(
    componentContext = componentContext,
    initialState = initialState
)