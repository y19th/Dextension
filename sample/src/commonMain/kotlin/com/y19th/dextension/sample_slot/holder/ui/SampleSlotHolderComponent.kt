package com.y19th.dextension.sample_slot.holder.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.value.Value
import com.y19th.dextension.core.singleSlot
import com.y19th.dextension.koin.components.KoinScreenComponent
import com.y19th.dextension.koin.getScreen
import com.y19th.dextension.sample_slot.holder.logic.SampleSlotHolderEvents
import com.y19th.dextension.sample_slot.holder.logic.SampleSlotHolderState
import com.y19th.dextension.sample_slot.navigation.SlotConfiguration
import com.y19th.dextension.sample_slot.slot.events.SlotNavigationEvents
import com.y19th.dextension.sample_slot.slot.ui.SlotScreen

internal class SampleSlotHolderComponent(
    componentContext: ComponentContext
) : KoinScreenComponent<SampleSlotHolderState, SampleSlotHolderEvents>(
    componentContext = componentContext,
    initialState = SampleSlotHolderState()
) {
    private val navigation = singleSlot(SlotConfiguration.serializer())
    val slot: Value<ChildSlot<*, SlotScreen>> = navigation.create { _, context -> getScreen(context) }

    init {
        launch {
            handleStorageEvent<SlotNavigationEvents> {
                when (this) {
                    SlotNavigationEvents.OnDismiss -> {
                        navigation.dismiss()
                    }

                    is SlotNavigationEvents.OnSharedStateChanged -> {
                        update { copy(sharedState = newValue) }
                    }
                }
            }
        }
    }

    override fun handleEvent(event: SampleSlotHolderEvents) {
        when (event) {
            SampleSlotHolderEvents.OnActivateSlot -> {
                navigation.activate(SlotConfiguration)
            }
        }
    }
}