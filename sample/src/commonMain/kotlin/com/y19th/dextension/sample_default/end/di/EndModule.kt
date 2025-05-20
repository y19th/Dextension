package com.y19th.dextension.sample_default.end.di

import com.y19th.dextension.sample_default.end.ui.EndComponent
import com.y19th.dextension.sample_default.end.ui.EndScreen
import com.y19th.dextension.sample_default.end.ui.EndScreenImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val endModule = module {
    factoryOf(::EndComponent)
    factoryOf(::EndScreenImpl).bind<EndScreen>()
}