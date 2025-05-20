package com.y19th.dextension.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable

@Composable
@NonRestartableComposable
fun ProvideContent(screen: Screen) {
    screen.Content()
}