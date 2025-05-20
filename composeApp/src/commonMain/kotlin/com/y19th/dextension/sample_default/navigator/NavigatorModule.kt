package com.y19th.dextension.sample_default.navigator

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val navigatorModule = module {
    singleOf(::MainNavigatorImpl).bind<MainNavigator>()
}