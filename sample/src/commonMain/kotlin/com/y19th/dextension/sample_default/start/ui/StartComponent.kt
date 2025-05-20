package com.y19th.dextension.sample_default.start.ui

import com.arkivanov.decompose.ComponentContext
import com.y19th.dextension.core.ScreenComponent
import com.y19th.dextension.extensions.scheduleCoroutine
import com.y19th.dextension.sample_default.navigator.MainNavigator
import com.y19th.dextension.sample_default.start.logic.StartEvents
import com.y19th.dextension.sample_default.start.logic.StartState

internal class StartComponent(
    componentContext: ComponentContext,
    private val navigator: MainNavigator
) : ScreenComponent<StartState, StartEvents>(
    componentContext = componentContext,
    initialState = StartState()
) {
    init {
        launch {
            scheduleCoroutine(1000) {
                update { copy(counter = counter.plus(1)) }
            }
        }
    }

    override fun handleEvent(event: StartEvents) {
        when (event) {
            StartEvents.OnCounterIncrement -> {
                update { copy(counter = counter.plus(1)) }
            }

            StartEvents.OnNavigateToSecond -> {
                navigator.toEnd()
            }
        }
    }
}