package com.y19th.dextension.sample_default.root.ui

import androidx.compose.runtime.Composable
import com.y19th.dextension.compose.DefaultChildren
import com.y19th.dextension.compose.ProvideContent

@Composable
internal fun RootContent(component: RootComponent) {
    DefaultChildren(
        stack = component.stack
    ) {
        ProvideContent(
            when (it) {
                is RootComponent.Child.End -> it.screen
                is RootComponent.Child.Start -> it.screen
                is RootComponent.Child.Slot -> it.screen
            }
        )
    }
}