package com.y19th.dextension.extensions.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Triggers delay before evaluating block
 * */
suspend inline fun afterDelay(
    millis: Long,
    block: () -> Unit
) {
    delay(millis)
    block()
}

/**
 * Triggers delay only after evaluating block
 * */
suspend inline fun beforeDelay(
    millis: Long,
    block: () -> Unit
) {
    block()
    delay(millis)
}

/**
 * Changes [onEach] block coroutine context dispatcher on [Dispatchers.Default].
 * */
fun <T> Flow<T>.onDefaultDispatcher(block: suspend (T) -> Unit): Flow<T> =
    onEach(block).flowOn(Dispatchers.Default)

/**
 * Launches coroutine on [Dispatchers.Main] dispatcher.
 * */
fun CoroutineScope.onMain(block: suspend CoroutineScope.() -> Unit): Job =
    launch(
        context = Dispatchers.Main.immediate,
        block = block
    )

/**
 * Launches coroutine on [Dispatchers.Default] dispatcher.
 * */
fun CoroutineScope.onDefault(block: suspend CoroutineScope.() -> Unit): Job =
    launch(
        context = Dispatchers.Default,
        block = block
    )

/**
 * Launches coroutine on [Dispatchers.Default] dispatcher with limited thread count.
 * */
fun CoroutineScope.onLimitedDefault(block: suspend CoroutineScope.() -> Unit): Job =
    launch(
        context = Dispatchers.Default.limitedParallelism(1),
        block = block
    )

/**
 * Changes dispatcher of current coroutine on [Dispatchers.Main].
 * */
suspend inline fun <T> withMain(noinline block: suspend CoroutineScope.() -> T): T =
    withContext(Dispatchers.Main.immediate, block)