package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.y19th.dextension.core.BaseEvents
import com.y19th.dextension.core.BaseState
import com.y19th.dextension.core.ScreenComponent

/**
 * Preventing recomposition because of [ScreenComponent.handleEvent] function.
 * Covering [ScreenComponent.handleEvent] with remember block.
* */
@Composable
fun <State : BaseState, Events : BaseEvents> ScreenComponent<State, Events>.rememberHandleEvents(): ((Events) -> Unit) =
    remember { { handleEvent(it) } }
