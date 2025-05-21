package com.y19th.dextension.sample_slot.slot.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.sample_slot.slot.events.SlotNavigationEvents
import com.y19th.dextension.sample_slot.slot.events.SlotNavigationEvents.OnSharedStateChanged
import com.y19th.dextension.sample_slot.slot.logic.SlotEvents
import com.y19th.dextension.sample_slot.slot.logic.SlotState

internal class SlotComponent(
    componentContext: ComponentContext
) : ScreenComponent<SlotState, SlotEvents>(
    componentContext = componentContext,
    initialState = SlotState()
) {
    override fun handleEvent(event: SlotEvents) {
        when (event) {
            SlotEvents.OnIncrement -> {
                update { copy(innerState = innerState.plus(1)) }
                storage.handle(OnSharedStateChanged(state.value.innerState))
            }

            SlotEvents.OnDismiss -> {
                storage.handle(SlotNavigationEvents.OnDismiss)
            }
        }
    }
}