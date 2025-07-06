package com.y19th.dextension.core.util

import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.y19th.dextension.core.BaseComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

internal fun BaseComponent.defaultCoroutineScope(
    context: CoroutineContext,
    handler: CoroutineExceptionHandler? = null,
    tag: String? = "BaseComponentTag"
): CoroutineScope =
    coroutineScope(context = context + (handler ?: screenCoroutineExceptionHandler(tag)))

internal fun componentCoroutineContext() = Dispatchers.Main.immediate + SupervisorJob()

