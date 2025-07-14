package com.y19th.dextension.extensions

import com.arkivanov.essenty.lifecycle.coroutines.repeatOnLifecycle
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.CoroutineScheduler
import com.y19th.dextension.extensions.coroutine.Scheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
* Providing for [ScreenComponent] default scheduling function via [CoroutineScheduler].
* */
fun ScreenComponent<*, *>.scheduleCoroutine(
    delay: Long,
    delayOnStart: Long = 0,
    block: suspend Scheduler.() -> Unit
): Job {
    val scheduler = CoroutineScheduler(
        initialDelay = delay,
        delayOnStart = delayOnStart,
        block = block
    )

    return scope.launch(Dispatchers.Default) {
        repeatOnLifecycle {
            scheduler.start()
        }
    }
}
