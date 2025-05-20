package com.y19th.dextension.sample_default.start.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.KoinScreen
import com.y19th.dextension.koin.getComponent

interface StartScreen : KoinScreen

internal class StartScreenImpl(
    override val componentContext: ComponentContext
) : StartScreen {

    private val component: StartComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        StartContent(component)
    }
}