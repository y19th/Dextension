package com.y19th.dextension.sample_default.navigator

import kotlinx.serialization.Serializable

@Serializable
sealed interface MainConfiguration {

    @Serializable
    data object Start: MainConfiguration

    @Serializable
    data object End: MainConfiguration

    @Serializable
    data object Slot: MainConfiguration
}