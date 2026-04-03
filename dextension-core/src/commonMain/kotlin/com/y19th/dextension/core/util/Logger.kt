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
                throwable = throwable,
                tag = tag
            ) { message }
        }

        LoggerLevel.Debug -> {
            Logger.d(
                throwable = throwable,
                tag = tag
            ) { message }
        }

        LoggerLevel.Error -> {
            Logger.e(
                throwable = throwable,
                tag = tag
            ) { message }
        }

        LoggerLevel.Info -> {
            Logger.i(
                throwable = throwable,
                tag = tag
            ) { message }
        }

        LoggerLevel.Verbose -> {
            Logger.v(
                throwable = throwable,
                tag = tag
            ) { message }
        }

        LoggerLevel.Warning -> {
            Logger.w(
                throwable = throwable,
                tag = tag
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

