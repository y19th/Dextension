package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.util.componentCoroutineContext
import com.y19th.dextension.core.util.defaultCoroutineScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Main component that has state and events. Provides:
 * - [state] property for subscribe on screen function.
 * - [handleEvent] function for handling [Event] instances.
 * - [storage] property with [ComponentEventsStorage] type.
 *
 * Inherited from [BaseComponent].
 *
 * @param componentContext context from parent
 * @param initialState initial instance for state.
 * @param coroutineContext replacing coroutine context of [scope].
 * @param coroutineHandler replacing coroutine exception handler of [scope].
 *
 * @sample com.y19th.dextension.core.sample.SampleScreenComponent
 * */
@Suppress("PropertyName")
abstract class ScreenComponent<State : BaseState, in Event : BaseEvents>(
    componentContext: ComponentContext,
    initialState: State,
    coroutineContext: CoroutineContext = componentCoroutineContext(),
    coroutineHandler: CoroutineExceptionHandler? = null
) : BaseComponent, ComponentContext by componentContext {

    protected val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val storage: ComponentEventsStorage by lazy { ComponentEventsStorageProvider.get() }
    private val tag: String = this::class.simpleName ?: "BaseTag"
    override val scope: CoroutineScope = defaultCoroutineScope(
        context = coroutineContext,
        handler = coroutineHandler,
        tag = tag
    )


    protected inline fun <Result> withState(block: State.() -> Result): Result {
        return with(
            receiver = state.value,
            block = block
        )
    }

    protected fun message(msg: String) {
        com.y19th.dextension.core.util.message(message = msg, tag = tag)
    }

    protected inline fun update(function: State.() -> State) {
        _state.update { function(it) }
    }

    protected fun pushStorageEvent(event: ComponentEvent?) {
        storage.handle(event)
    }

    protected suspend inline fun <reified T : ComponentEvent> handleStorageEvent(
        crossinline block: suspend T.() -> Unit
    ) {
        storage.onEvent<T>(block)
    }

    protected inline fun <reified T : ComponentEvent> handleStorageEventOnMainThread(
        crossinline block: suspend T.() -> Unit
    ) {
        scope.launch(Dispatchers.Main.immediate) {
            handleStorageEvent<T>(block)
        }
    }

    abstract fun handleEvent(event: Event)
}
