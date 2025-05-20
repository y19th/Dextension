package com.y19th.dextension.core.util

import co.touchlab.kermit.Logger


internal fun message(
    tag: String,
    message: String,
    level: LoggerLevel = LoggerLevel.Debug,
    throwable: Throwable? = null
) {
    when (level) {
        LoggerLevel.Assert -> {
            Logger.a(
                tag,
                throwable
            ) { message }
        }

        LoggerLevel.Debug -> {
            Logger.d(
                tag,
                throwable
            ) { message }
        }

        LoggerLevel.Error -> {
            Logger.e(
                tag,
                throwable
            ) { message }
        }

        LoggerLevel.Info -> {
            Logger.i(
                tag,
                throwable
            ) { message }
        }

        LoggerLevel.Verbose -> {
            Logger.v(
                tag,
                throwable
            ) { message }
        }

        LoggerLevel.Warning -> {
            Logger.w(
                tag,
                throwable
            ) { message }
        }
    }
}

internal sealed interface LoggerLevel {

    data object Verbose : LoggerLevel

    data object Debug : LoggerLevel

    data object Info : LoggerLevel

    data object Warning : LoggerLevel

    data object Error : LoggerLevel

    data object Assert : LoggerLevel
}

