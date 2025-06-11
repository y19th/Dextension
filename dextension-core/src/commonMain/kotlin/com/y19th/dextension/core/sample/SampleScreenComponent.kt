package com.y19th.dextension.core.sample

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.BaseEvents
import com.y19th.dextension.core.BaseState
import com.y19th.dextension.core.ScreenComponent

internal data class SampleState(
    val foo: Int = 0
) : BaseState

internal sealed interface SampleEvents : BaseEvents {

    data object OnFoo : SampleEvents

    data class OnBar(val bar: Int) : SampleEvents
}

internal class SampleScreenComponent(
    componentContext: ComponentContext
) : ScreenComponent<SampleState, SampleEvents>(
    initialState = SampleState(),
    componentContext = componentContext
) {
    override fun handleEvent(event: SampleEvents) {
        when (event) {
            is SampleEvents.OnBar -> {
                update { copy(foo = event.bar) }
            }

            SampleEvents.OnFoo -> {

            }
        }
    }
}