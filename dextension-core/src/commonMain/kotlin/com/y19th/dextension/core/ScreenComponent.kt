package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Suppress("PropertyName")
abstract class ScreenComponent<State : BaseState, in Event : BaseEvents>(
    componentContext: ComponentContext,
    initialState: State
) : BaseComponent(componentContext) {

    protected val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val storage: ComponentEventsStorage by lazy { ComponentEventsStorageImpl() }


    protected inline fun <Result> withState(block: State.() -> Result): Result {
        return with(
            receiver = state.value,
            block = block
        )
    }

    protected inline fun update(function: State.() -> State) {
        _state.update { function(it) }
    }

    protected suspend inline fun <reified T : ComponentEvent> handleStorageEvent(
        noinline block: T.() -> Unit
    ) {
        storage.onEvent<T>(block)
    }

    protected fun launch(block: suspend CoroutineScope.() -> Unit): Job {
        return scope.launch(block = block)
    }


    abstract fun handleEvent(event: Event)
}
