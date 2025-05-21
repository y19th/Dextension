package com.y19th.dextension.sample_slot.holder.di

import com.y19th.dextension.sample_slot.holder.ui.SampleSlotHolderComponent
import com.y19th.dextension.sample_slot.holder.ui.SampleSlotHolderScreen
import com.y19th.dextension.sample_slot.holder.ui.SampleSlotHolderScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sampleSlotHolderModule = module {
    factoryOf(::SampleSlotHolderComponent)
    factoryOf(::SampleSlotHolderScreenImpl).bind<SampleSlotHolderScreen>()
}