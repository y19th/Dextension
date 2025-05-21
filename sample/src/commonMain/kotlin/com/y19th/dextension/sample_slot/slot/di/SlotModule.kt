package com.y19th.dextension.sample_slot.slot.di

import com.y19th.dextension.sample_slot.slot.ui.SlotComponent
import com.y19th.dextension.sample_slot.slot.ui.SlotScreen
import com.y19th.dextension.sample_slot.slot.ui.SlotScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val slotModule = module {
    factoryOf(::SlotComponent)
    factoryOf(::SlotScreenImpl).bind<SlotScreen>()
}