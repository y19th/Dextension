package com.y19th.dextension.extensions.coroutine

interface Scheduler {

    fun changeDelay(delay: Long)

    fun recoverDelay()

    fun stop()

    suspend fun start()
}

