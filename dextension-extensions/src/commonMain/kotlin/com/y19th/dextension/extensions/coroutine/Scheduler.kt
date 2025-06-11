package com.y19th.dextension.extensions.coroutine

/**
* Interface for schedulers. Main implementation is [CoroutineScheduler].
* */
interface Scheduler {

    fun changeDelay(delay: Long)

    fun recoverDelay()

    fun stop()

    suspend fun start()
}

