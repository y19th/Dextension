package com.y19th.dextension.extensions.coroutine

import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext

class CoroutineScheduler(
    private val initialDelay: Long,
    private val delayOnStart: Long = 0,
    private val block: suspend CoroutineScheduler.() -> Unit
) : Scheduler {

    private var _delay = initialDelay
    private var _needRetry = true
    private var _delayExpired = true

    override fun changeDelay(delay: Long) {
        _delay = delay
    }

    override fun recoverDelay() {
        _delay = initialDelay
    }

    override fun stop() {
        _needRetry = false
    }

    override suspend fun start() {
        while (_needRetry) {
            coroutineContext.ensureActive()
            afterDelay(if (_delayExpired) _delay else delayOnStart) {
                _delayExpired = true
                block()
            }
        }
    }
}