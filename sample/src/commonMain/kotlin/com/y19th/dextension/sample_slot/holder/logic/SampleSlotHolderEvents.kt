package com.y19th.dextension.sample_slot.holder.logic

import com.y19th.dextension.core.BaseEvents

internal sealed interface SampleSlotHolderEvents: BaseEvents {

    data object OnActivateSlot: SampleSlotHolderEvents
}