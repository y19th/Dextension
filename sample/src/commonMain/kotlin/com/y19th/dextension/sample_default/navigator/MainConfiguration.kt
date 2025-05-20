package com.y19th.dextension.sample_default.navigator

import kotlinx.serialization.Serializable

@Serializable
sealed interface MainConfiguration {

    @Serializable
    data object StartConfiguration: MainConfiguration

    @Serializable
    data object EndConfiguration: MainConfiguration
}