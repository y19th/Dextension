package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow

/**
* Collecting component state on immediate main dispatcher.
* */
@Composable
fun <T> StateFlow<T>.collectAsImmediateState(): State<T> {
    return collectAsState(
        context = Dispatchers.Main.immediate
    )
}