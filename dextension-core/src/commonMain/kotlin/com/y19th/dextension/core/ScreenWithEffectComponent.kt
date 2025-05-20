package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

abstract class ScreenWithEffectComponent<State : BaseState, Events : BaseEvents, Effect : BaseEffects>(
    componentContext: ComponentContext,
    initialState: State
) : ScreenComponent<State, Events>(
    componentContext = componentContext,
    initialState = initialState
) {
    private val _sideEffects = Channel<Effect?>()
    val sideEffects = _sideEffects.receiveAsFlow()

    protected fun sideEffect(effect: Effect) {
        _sideEffects.trySend(effect)
    }
}