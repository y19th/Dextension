package com.y19th.dextension.sample_slot.slot.logic

import com.y19th.dextension.core.BaseEvents

internal sealed interface SlotEvents: BaseEvents {

    data object OnIncrement: SlotEvents

    data object OnDismiss: SlotEvents
}