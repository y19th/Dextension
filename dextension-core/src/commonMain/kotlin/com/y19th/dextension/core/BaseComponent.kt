package com.y19th.dextension.core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope

/**
 * Base component for all other components. Provides into children [CoroutineScope] and all subcomponents of [ComponentContext].
 * */
interface BaseComponent : ComponentContext {

    val scope: CoroutineScope
}