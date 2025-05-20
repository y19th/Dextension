package com.y19th.dextension.sample_default.end.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.sample_default.end.logic.EndEvents
import com.y19th.dextension.sample_default.end.logic.EndState
import com.y19th.dextension.sample_default.navigator.MainNavigator

internal class EndComponent(
    componentContext: ComponentContext,
    private val navigator: MainNavigator
) : ScreenComponent<EndState, EndEvents>(
    componentContext = componentContext,
    initialState = EndState()
) {
    override fun handleEvent(event: EndEvents) {
        when (event) {
            EndEvents.OnCounterIncrement -> {
                update { copy(counter = counter.plus(1)) }
            }

            EndEvents.OnNavigateToFirst -> {
                navigator.toStart()
            }
        }
    }
}