package com.y19th.dextension.sample_default.root.di

import com.y19th.dextension.sample_default.root.ui.RootComponent
import com.y19th.dextension.sample_default.root.ui.RootScreen
import com.y19th.dextension.sample_default.root.ui.RootScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val rootModule = module {
    factoryOf(::RootComponent)
    factoryOf(::RootScreenImpl).bind<RootScreen>()
}