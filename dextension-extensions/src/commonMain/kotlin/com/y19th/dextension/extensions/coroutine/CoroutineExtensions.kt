package com.y19th.dextension.extensions.coroutine

import kotlinx.coroutines.delay

/**
 * triggers delay before evaluating block
 * */
internal suspend inline fun afterDelay(
    millis: Long,
    block: () -> Unit
) {
    delay(millis)
    block.invoke()
}

/**
 * triggers delay only after evaluating block
 * */
internal suspend inline fun beforeDelay(
    millis: Long,
    block: () -> Unit
) {
    block.invoke()
    delay(millis)
}