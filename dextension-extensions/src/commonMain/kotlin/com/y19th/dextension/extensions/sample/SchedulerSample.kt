package com.y19th.dextension.extensions.sample

import com.y19th.dextension.extensions.coroutine.CoroutineScheduler

suspend fun apiCall(): Result<Nothing> {
    TODO()
}

suspend fun sampleSchedule() {
    CoroutineScheduler(5000) {
        apiCall()
            .onSuccess {
                //manipulate with result
                recoverDelay()
            }
            .onFailure {
                //manipulate with error
                changeDelay(15000)
            }
    }.start()
}