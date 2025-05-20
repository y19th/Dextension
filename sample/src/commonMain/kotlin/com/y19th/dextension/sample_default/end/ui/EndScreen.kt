package com.y19th.dextension.sample_default.end.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.KoinScreen
import com.y19th.dextension.koin.getComponent

interface EndScreen : KoinScreen

internal class EndScreenImpl(
    override val componentContext: ComponentContext
) : EndScreen {

    private val component: EndComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        EndContent(component)
    }
}