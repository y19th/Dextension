package com.y19th.dextension.sample_default.start.di

import com.y19th.dextension.sample_default.start.ui.StartComponent
import com.y19th.dextension.sample_default.start.ui.StartScreen
import com.y19th.dextension.sample_default.start.ui.StartScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val startModule = module {
    factoryOf(::StartComponent)
    factoryOf(::StartScreenImpl).bind<StartScreen>()
}