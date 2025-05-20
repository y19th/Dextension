package com.y19th.dextension.extensions

import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.coroutine.CoroutineScheduler
import com.y19th.dextension.extensions.coroutine.Scheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ScreenComponent<*, *>.scheduleCoroutine(
    delay: Long,
    delayOnStart: Long = 0,
    block: suspend Scheduler.() -> Unit
) {
    val scheduler = CoroutineScheduler(
        initialDelay = delay,
        delayOnStart = delayOnStart,
        block = block
    )

    scope.launch(Dispatchers.Default) {
        scheduler.start()
    }
}
