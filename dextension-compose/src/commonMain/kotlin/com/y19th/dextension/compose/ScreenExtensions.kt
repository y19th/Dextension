package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

/**
 * Providing content from [Screen].
* */
@Composable
@NonRestartableComposable
fun ProvideContent(screen: Screen) {
    screen.Content()
}