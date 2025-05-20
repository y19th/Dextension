package com.y19th.dextension.compose

import com.arkivanov.essenty.backhandler.BackCallback
import com.arkivanov.essenty.backhandler.BackHandler


fun BackHandler.enable(callback: BackCallback) {
    if (isRegistered(callback))
        callback.isEnabled = true
    else
        register(callback).also {
            callback.isEnabled = true
        }
}

fun BackHandler.enableDefaultWrapper() {
    val callback = BackCallback(priority = Int.MAX_VALUE) {}
    if (isRegistered(callback))
        callback.isEnabled = true
    else
        register(callback).also {
            callback.isEnabled = true
        }
}