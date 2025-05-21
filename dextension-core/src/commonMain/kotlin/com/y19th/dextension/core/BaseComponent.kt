package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.y19th.dextension.core.util.screenCoroutineExceptionHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

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