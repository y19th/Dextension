package com.y19th.dextension.sample_slot.holder.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.koin.KoinScreen
import com.y19th.dextension.koin.getComponent

interface SampleSlotHolderScreen : KoinScreen

internal class SampleSlotHolderScreenImpl(
    override val componentContext: ComponentContext
) : SampleSlotHolderScreen {

    private val component: SampleSlotHolderComponent = getComponent(componentContext)

    @Composable
    override fun Content() {
        SampleSlotHolderContent(component)
    }
}