package com.y19th.dextension.sample_slot.slot.events

import com.y19th.dextension.core.ComponentEvent

sealed interface SlotNavigationEvents: ComponentEvent {

    data class OnSharedStateChanged(val newValue: Int): SlotNavigationEvents

    data object OnDismiss: SlotNavigationEvents
}