package com.y19th.dextension.koin

import com.y19th.dextension.compose.Screen
import com.y19th.dextension.core.BaseComponent
import org.koin.core.component.KoinComponent

/**
 * Wrapper on [Screen] with [KoinComponent].
 * */
interface KoinScreen : Screen, KoinComponent