package com.y19th.dextension.sample_slot.slot.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.KoinScreen
import com.y19th.dextension.koin.getComponent

interface SlotScreen : KoinScreen

internal class SlotScreenImpl(
    override val componentContext: ComponentContext
) : SlotScreen {

    private val component: SlotComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        SlotContent(component)
    }
}