package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.y19th.dextension.core.util.screenCoroutineExceptionHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * Base component for all other components. Provides:
 * - [CoroutineExceptionHandler] for handing errors in scope
 * - [CoroutineScope] for launching coroutine inside component. Uses lifecycle of context, and cancelling coroutine if component destroyed.
 * - [message] function for logging.
 *
 * You can provide your own [CoroutineExceptionHandler] by constructor. It uses default handler if no handler provided.
 *
 * Usually used for navigation holder components.
 *
 * @sample com.y19th.dextension.core.sample.SampleBaseComponent
 * */
abstract class BaseComponent(
    componentContext: ComponentContext,
    coroutineExceptionHandler: CoroutineExceptionHandler? = null
) : ComponentContext by componentContext {

    private val tag = this::class.simpleName
    val scope = coroutineScope(
        context = (coroutineExceptionHandler ?: screenCoroutineExceptionHandler(tag)) +
                Dispatchers.Main.immediate +
                SupervisorJob()
    )

    protected fun message(msg: String) {
        com.y19th.dextension.core.util.message(tag ?: "BaseTag", msg)
    }
}