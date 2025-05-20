package com.y19th.dextension.sample_default.navigator

import com.y19th.dextension.core.BaseNavigator

interface MainNavigator: BaseNavigator<MainConfiguration> {

    fun toEnd()

    fun toStart()
}